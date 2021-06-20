(function (a) {
    a.info = {
        url: "../handlers/info.ashx",
        heart: function (id) {
            if (!_login_check()) return;
            a.post(this.url, {
                act: 'heart',
                info: id
            },
			function (result) {
			    if (result.result == 'success') {
			        a('.heart[data="' + id + '"]').html(result.num);
			    } else if (result.result == 'unlog') {
			        _login();
			    } else {
			    }
			}, 'json');
        },
        favorite: function (id) {
            if (!_login_check()) return;
            a.post(this.url, {
                act: 'favorite',
                info: id
            },
			function (result) {
			    if (result.result == 'success') {
			        a('.star[data="' + id + '"]').html(result.num);
			    } else if (result.result == 'unlog') {
			        _login();
			    } else {
			    }
			}, 'json');
        },
        comment_pop: function (id) {
            if (!_login_check()) return;
            var _html = '<div id="pop_window"><div id="pop_content"><div class="pop_content_inner"></div></div></div><div id="pop_overlay" class="pop_overlay" onclick="pop_close()"></div>';
            $("body", "html").css({
                height: "100%",
                width: "100%"
            });
            $("body").append(_html);
            $('.pop_content_inner').html($('#jsComment').html());
            a('#btn_comment').click(function () {
                a.info.comment(id);
            });
        },
        comment: function (id) {
            if (!_login_check()) return;
            var cont = a('#comment_cont').val();
            if (cont == '') {
                alert('\u8bc4\u8bba\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a');
                return;
            }
            a.post(this.url, {
                act: 'comment',
                info: id,
                cont: cont
            },
			function (result) {
			    if (result.result == 'success') {
			        a('.comm[data="' + id + '"]').html(result.num);
			    } else if (result.result == 'unlog') {
			        _login();
			    }
			    pop_close();
			}, 'json');
        },
        initial: function () {
            $('.img-item .heart').unbind( "click" ).click(function () {
                $.info.heart($(this).attr('data'));
            });
            $('.img-item .star').unbind("click").click(function () {
                $.info.favorite($(this).attr('data'));
            });
            $('.img-item .comm').unbind("click").click(function () {
                $.info.comment_pop($(this).attr('data'));
            });
        }
    }
})(jQuery);
(function (a) {
    a.msg = {
        url: "../handlers/msg.ashx",
        pop: function () {
            if (!_login_check()) return;
            var _html = '<div id="pop_window"><div id="pop_content"><div class="pop_content_inner"></div></div></div><div id="pop_overlay" class="pop_overlay" onclick="pop_close()"></div>';
            $("body", "html").css({
                height: "100%",
                width: "100%"
            });
            $("body").append(_html);
            $('.pop_content_inner').html($('#jsWin').html());
        },
        send: function () {
            if (!_login_check()) return;
            var cont = a('#msg_cont').val();
            if (cont == '') {
                alert('\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a');
                return;
            }
            a.post(this.url, {
                act: 'send',
                user: a('#msg_user').val(),
                cont: cont
            },
			function (result) {
			    if (result == 'success') {
			        pop_close();
			        alert('\u53d1\u9001\u6210\u529f');
			    } else {
			    }
			});
        }
    }
})(jQuery);

$(document).ready(function () {
    $.info.initial();
});

var flag = true;
var $container = $('.cont_wrap');
$container.masonry({
    singleMode: true,
    animate: true,
    resizeable: true,
    itemSelector: '.grid-item'
});
$(window).scroll(function () {
    if (!flag) return;
    if ($(document).height() - $(this).scrollTop() - $(this).height() < 500) {
        var pl = parseInt($('#_page').val()), pn = parseInt($('#_pagenum').val());
        if (pl >= pn) {
            $('.complete').show(); $('.loading').hide(); return;
        } else {
            $('.loading').show();
            load_data();
        }
    }
});
function load_data() {
    flag = false;
    var pl = parseInt($('#_page').val()), pn = parseInt($('#_pagenum').val()), ci = $('#_category').val(), ui = $('#_user').val(), ky = $('#_key').val();
    $.ajax({
        url: 'getlist.aspx',
        type: 'get',
        data: { category: ci, author: ui, key: ky, page: pl + 1 },
        success: function (data) {
            var $boxes = $(data);
            $container.append($boxes).masonry("appended", $boxes, true);
            $('.loading').hide();
            $('#_page').val(pl + 1);
            flag = true;
            $.info.initial();
        }
    });
}
function load_data_right() {
    var pl = parseInt($('#_page').val()), pn = parseInt($('#_pagenum').val()), ci = $('#_category').val(), ky = $('#_key').val();
    $.ajax({
        url: 'getlist.aspx',
        type: 'get',
        data: { category: ci, key: ky, page: pl, act: 'original' },
        success: function (data) {
            $('.cont_right').append(data);
            $.info.initial();
        }
    });
}
$(window).resize(function () {
    if ($(window).width() < 1260) {
        $('.cont_wrap').width(1008);
    } else {
        $('.cont_wrap').width(1260);
    }
    $container.masonry({
        singleMode: true,
        animate: true,
        resizeable: true,
        itemSelector: '.grid-item'
    });
});
var reload = setInterval(function () {
    $container.masonry({
        singleMode: true,
        animate: true,
        resizeable: true,
        itemSelector: '.grid-item'
    });
}, 1000);
