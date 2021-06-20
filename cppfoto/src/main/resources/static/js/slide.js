$(document).ready(function() {
    var system = {
        init: function(navigator) {
            var platforms = this.platforms,
				ln = platforms.length,
				i, platform;
            navigator = navigator || window.navigator;

            for (i = 0; i < ln; i++) {
                platform = platforms[i];
                this[platform.identity] = platform.regex.test(navigator[platform.property]);
            }
            this.Desktop = this.Mac || this.Windows || (this.Linux && !this.Android);
            this.Tablet = this.iPad;
            this.Phone = !this.Desktop && !this.Tablet;
            this.iOS = this.iPhone || this.iPad || this.iPod;
            this.Standalone = !!window.navigator.standalone;
        },
        platforms: [
			{ property: 'platform', regex: /iPhone/i, identity: 'iPhone' },
			{ property: 'platform', regex: /iPod/i, identity: 'iPod' },
			{ property: 'userAgent', regex: /iPad/i, identity: 'iPad' },
			{ property: 'userAgent', regex: /Blackberry/i, identity: 'Blackberry' },
			{ property: 'userAgent', regex: /Android/i, identity: 'Android' },
			{ property: 'platform', regex: /Mac/i, identity: 'Mac' },
			{ property: 'platform', regex: /Win/i, identity: 'Windows' },
			{ property: 'platform', regex: /Linux/i, identity: 'Linux' },
			{ property: 'userAgent', regex: /msie/i, identity: 'IE' },
			{ property: 'userAgent', regex: /gecko/i, identity: 'MOZ' },
			{ property: 'userAgent', regex: /Chrome/i, identity: 'Chrome' },
			{ property: 'userAgent', regex: /MSIE 9.0/i, identity: 'IE9' },
			{ property: 'userAgent', regex: /360SE/i, identity: 'SE360' },
			{ property: 'userAgent', regex: /360EE/i, identity: 'EE360' },
			{ property: 'userAgent', regex: /Maxthon/i, identity: 'Maxthon' },
			{ property: 'userAgent', regex: /Firefox/i, identity: 'Firefox' }
		]
    };

    var indexSlide = {
        index: 0,
        count: 0,
        width: 1200,
        atxt: null,
        itxt: null,
        flag: true,
        interval: null,
        init: function(nodePic, nodetxt, pic, pass) {

            system.init();
            // var isios = system.iOS ? 1 : 0;
            var isios = 0;
            var ulSlide = $(nodePic);
            var ultab = ulSlide.parent();

            indexSlide.atxt = ulSlide.find(pic);
            indexSlide.itxt = ultab.find(nodetxt);
            indexSlide.count = $(ulSlide).children().length;
            if (indexSlide.count == 1) {
                indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
                return;
            }
            if (pass) {
                var ulli = '';
                for (i = 1; i <= indexSlide.count; i++) {
                    ulli += "<li></li>";
                }
                ultab.append('<ul id="culFocus">' + ulli + '</ul><a id="clinkSlideLeft" href="javascript:void(0);" class="foucs_left"></a><a id="clinkSlideRight" href="javascript:void(0);" class="foucs_right"></a>');
            }

            $("#culFocus li").eq(0).addClass('cursor');

            $("#clinkSlideLeft,#clinkSlideRight")
				.hover(function() {
				    if ($(this).hasClass("foucs_left")) {
				        $(this).addClass("foucs_left_cur");
				    } else {
				        $(this).addClass("foucs_right_cur");
				    }
				}, function() {
				    if ($(this).hasClass("foucs_left")) {
				        $(this).removeClass("foucs_left_cur");
				    } else {
				        $(this).removeClass("foucs_right_cur");
				    }
				});

            if (indexSlide.count == 0) {

                return;
            }

            var liFirst = $(ulSlide).find("p").first().clone();
            var liLast = $(ulSlide).find("p").last().clone();
            $(ulSlide).append(liFirst).append(liLast);

            // 长度
            $(ulSlide).css({
                width: indexSlide.width * $(ulSlide).find("p").length
            });

            $("#culFocus li").each(function(i) {
                if (isios == 1) {
                    $(this).click(function() {
                        indexSlide.select(i);
                    });
                } else {
                    $(this).hover(function() {
                        indexSlide.move(i);
                    }, function() {
                        var ulSlide = $("#cSlide");
                        $(ulSlide).stop();
                        var intLeft = 0 - i * indexSlide.width;
                        $(ulSlide).css("marginLeft", intLeft + "px");
                        indexSlide.flag = true;
                        indexSlide.run();
                    });
                }
            });

            if (isios == 1) {
                fnslide(jQuery);

                $(ulSlide).touchwipe({
                    min_move_x: 40,
                    min_move_y: 40,
                    wipeLeft: function() {
                        indexSlide.right();
                    },
                    wipeRight: function() {
                        indexSlide.left();
                    },
                    preventDefaultEvents: true
                });
            } else {
                $("#clinkSlideLeft,#clinkSlideRight").hide();

                $(".focus").hover(function() {
                    $("#clinkSlideLeft,#clinkSlideRight").show();
                }, function(event) {
                    $("#clinkSlideLeft,#clinkSlideRight").hide();
                });
            }

            $("#clinkSlideLeft").click(indexSlide.left);
            $("#clinkSlideRight").click(indexSlide.right);
            indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
            indexSlide.run();
        },
        left: function() {

            if (!indexSlide.flag) {
                return;
            }
            indexSlide.stop();
            indexSlide.flag = false;

            var ulSlide = $("#cSlide");

            var intLeft = 0;
            if (indexSlide.index == 0) {
                intLeft = 0 - indexSlide.count * indexSlide.width;
                $(ulSlide).css("marginLeft", intLeft + "px");
                indexSlide.index = indexSlide.count;
            }

            indexSlide.index--;
            intLeft = 0 - indexSlide.index * indexSlide.width;

            indexSlide.focus();

            $(ulSlide).animate({
                marginLeft: intLeft + "px"
            }, 300, function() {
                indexSlide.flag = true;
                indexSlide.run();
            });

            indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
        },
        right: function() {

            if (!indexSlide.flag) {
                return;
            }

            indexSlide.stop();
            indexSlide.flag = false;
            indexSlide.index++;

            var intLeft = 0 - indexSlide.index * indexSlide.width;

            var ulSlide = $("#cSlide");

            indexSlide.focus();

            $(ulSlide).animate({
                marginLeft: intLeft + "px"
            }, 300, function() {
                if (indexSlide.index == indexSlide.count) {
                    $(ulSlide).css("marginLeft", "0px");
                    indexSlide.index = 0;
                }
                indexSlide.flag = true;
                indexSlide.run();
            });

            indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
        },
        focus: function() {
            $("#culFocus li").removeClass("cursor");

            if (indexSlide.index == indexSlide.count) {
                $("#culFocus li:first").addClass("cursor");
                indexSlide.itxt.text(indexSlide.atxt.eq(0).attr("alt"));
                return;
            }

            $("#culFocus li:eq(" + indexSlide.index + ")").addClass("cursor");

        },
        select: function(n) {

            if (!indexSlide.flag) {
                return;
            }

            indexSlide.stop();
            indexSlide.flag = false;
            indexSlide.index = n;
            var intLeft = 0 - indexSlide.index * indexSlide.width;
            var ulSlide = $("#cSlide");
            indexSlide.focus();

            $(ulSlide).animate({
                marginLeft: intLeft + "px"
            }, 300, function() {
                indexSlide.flag = true;
                indexSlide.run();
            });

            indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
        },
        move: function(n) {

            if (!indexSlide.flag) {
                return;
            }

            indexSlide.stop();
            indexSlide.flag = false;
            indexSlide.index = n;
            var intLeft = 0 - indexSlide.index * indexSlide.width;
            var ulSlide = $("#cSlide");
            indexSlide.focus();

            $(ulSlide).animate({
                marginLeft: intLeft + "px"
            }, 300, function() {
                indexSlide.flag = true;
            });

            indexSlide.itxt.text(indexSlide.atxt.eq(indexSlide.index).attr("alt"));
        },
        run: function() {
            if (indexSlide.interval != null) {
                return;
            }

            indexSlide.interval = setInterval(indexSlide.right, 6000);
        },
        stop: function() {
            clearInterval(indexSlide.interval);
            indexSlide.interval = null;
        }
    }

    new indexSlide.init("#cSlide", ".ic-a-c1 a", "img", true);



    //二
    var car_ul_leng = $('.oeibmse-i li').length;
    if (car_ul_leng <= 6) {
        for (i = 0; i < car_ul_leng; i++) {
            $('.oeibmse-i').append($('.oeibmse-i li:eq(' + i + ')').clone());
        }
    }
    // $('.oeibmse-i li:first').before($('.oeibmse-i li:last'));

    var car_li_leng = $('.oeibmse-i li').length * 294;
    $('.oeibmse-i').css({
        'width': car_li_leng,
        'left': 0
    });

    function AutoMotion() {

        var item_width = $('.oeibmse-i li').width();
        var left_indent = parseInt($('.oeibmse-i').css('left')) - item_width;
        $('.oeibmse-i:not(:animated)').animate({
            'left': left_indent
        }, 500, function() {
            $('.oeibmse-i li:last').after($('.oeibmse-i li:first'));
            $('.oeibmse-i').css({
                'left': '0px'
            });
        });
    }


    setInterval(function() {
        AutoMotion();
    }, 5000);

});