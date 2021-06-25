var cur = 1;
var p = true;
var ln = $('.photo_show').length;
function automation() {
    if (p) {
        cur++;
        if (cur >= ln) cur = 0;
        showPhoto(cur);
    }
}
//var palyer = setInterval(automation, 5000);
(function (a) {
    a.info = {
        url: "../handlers/info.ashx",
        articleid: a('#articleid').val(),
        initial:function(){
            a.info.face_load();
            a('.comment_box .tool_image').click(function(){
                a.info.img_upload();
            });
            a('.comment_box .tool_face').click(function(){
                $.info.face_show();
            });
            a('#comment_btn').click(function(){
                a.info.comment();
            });
            a('.comment_box .del').click(function(){
                a.info.img_delete();
            });
        },
        favorite: function (id) {
            if (!_login_check()) return;
            a.post(this.url, { act: 'favorite', info: id },
			function (result) {
			    if (result.result == 'success') {
			        $('.collect_num').html(result.num);
			        $('.favorite').addClass('favorited').removeClass('favorite');
			        $('.btnfavorite').unbind('click').click(function () { alert('\u5df2\u6536\u85cf'); return false; });
			        alert('\u6536\u85cf\u6210\u529f');
			    } else if (result.result == 'unlog') {
			        _login();
			    } else {
			        alert('\u64cd\u4f5c\u5931\u8d25');
			    }
			}, 'json');
        },
        heart: function (id) {
            if (!_login_check()) return;
            a.post(this.url, { act: 'heart', info: id },
			function (result) {
			    if (result.result == 'success') {
			        $('.heart_num').html(result.num);
			        $('.heart').addClass('hearted').removeClass('heart');
			        $('.btnheart').unbind('click');
			        $('.btnheart').click(function () { alert('\u5df2\u70b9\u8d5e'); return false; });

			        alert('\u70b9\u8d5e\u6210\u529f');
			    } else if (result.result == 'unlog') {
			        _login();
			    } else {
			        alert('\u64cd\u4f5c\u5931\u8d25');
			    }
			}, 'json');
        },
        report_pop: function (id) {
            if (!_login_check()) return;
            report_open();
            a('.pop-body #btn_submit').unbind('click').click(function () {
                a.info.report(id)
            });
        },
        report: function (id) {
            if (!_login_check()) return;
            var cont = $('#report_cont').val();
            if (cont == '') { alert('\u8bf7\u586b\u5199\u4e3e\u62a5\u5185\u5bb9'); return; }
            else if (cont.length > 100) { alert('字数不能多于100字'); return; }
            a.post(this.url,
            { act: 'report', info: id, cont: cont },
            function (result) {
                if (result == 'success') {
                    report_close();
                    alert('\u63d0\u4ea4\u6210\u529f\uff0c\u611f\u8c22\u60a8\u7684\u652f\u6301');
                } else if (result == 'unlog') {
                    _login();
                } else {
                    alert('\u63d0\u4ea4\u5931\u8d25');
                }
            });
        },
        face_load: function () {
            $.face.load(a('.comment_box .face'));
        },
        face_show: function () {
            a('.comment_box .toolcont .face').toggle();
            a('.comment_box .toolcont .face img').click(function () {
                a('.comment_box #comment_cont').insertContent(a(this).attr('title'));
            });
        },
        face_hide: function () {
            a('.comment_box .toolcont .face').hide();
        },
        img_upload: function() {
              if (!_login_check()) return;
        
            popOpen(a('#jsUploadComment').html());
        },
        img_show: function (is, ib) {
            a('.comment_box #comment_imgs').val(is + ',' + ib);
            a('.comment_box #comment_img img').attr('src', is); //.click(function () {popOpen('<div style="position:absolute;top:-50%;left:-50%;"><img src="' + ib + '" style="max-height:500px;" /></div>');});
            a('.comment_box .pic').show();
            popClose();
        },
        img_delete: function () {
            a('.comment_box .pic').hide();
            a('.comment_box #comment_imgs').val('');
            a('.comment_box #comment_img img').attr('src','');
        },
        comment:function(){
            if (!_login_check()) return;
            var cont = a('.comment_box #comment_cont').val();
            var imgs = a('.comment_box #comment_imgs').val();
            if (cont == '' && imgs == '') {
                alert('请填写评论内容');
                return false;
            }
            if (cont.length > 2000) {
                alert('评论内容不可多于2000字');
                return false;
            }
            a.post(this.url,
            { act: 'comment', info: this.articleid, cont: cont, imgs: imgs },
            function (result) {
                if (result.result == 'success') {
                    a.comment.list(1);
                    a.info.img_delete();
                    a.info.face_hide();
                    a('.comment_box #comment_cont').val('');
                    alert('\u63d0\u4ea4\u6210\u529f\uff0c\u611f\u8c22\u60a8\u7684\u652f\u6301');
                } else if (result.result == 'unlog') {
                    _login();
                } else {
                    alert('\u63d0\u4ea4\u5931\u8d25');
                }
            }, 'json');
        }
    }
})(jQuery);
(function (a) {
    a.comment = {
        url: "../handlers/infocomment.ashx",
        articleid: a('#articleid').val(),
        tool_show: function (o) {
            a(o).find('.toolbar a').show();
        },
        tool_hide: function (o) {
            a(o).find('.toolbar a').hide();
        },
        list: function (page) {
            a(".comment_list").load("../info/commentlist.aspx", { article: this.articleid, page: page }, function () {
                a('blockquote').each(function () {
                    var commentid = a(this).find('.commentid').val();
                    var userid = a(this).find('.userid').val();
                    var username = a(this).find('.username').val();
                    var hearted = a(this).find('.hearted').val();

                    a(this).find('.reply').click(function () {
                        if (!_login_check()) return;
                        var box = a(this).parent().siblings('.replybox');
                        if (a(box).html() == '') {
                            a('.replybox').html('').hide();
                            a(box).html(a('#jsReply').html()).show();
                            a('#reply_id').val(commentid)
                            a.comment.face_load();
                            a(box).find('.btn_img').click(function(){
                                a.comment.img_upload();
                            });
                            a(box).find('.btn_face').click(function(){
                                a.comment.face_show();
                            });
                            a(box).find('.btn_submit').click(function(){
                                a.comment.comment();
                            });
                        } else {
                            a(box).html('').hide();
                        }
                    });
                    a(this).find('.at').click(function () {
                        $.msg.pop(userid, username);
                    });
                    a(this).find('.up').click(function () {
                        if (hearted == '1') { alert('不可重复点赞'); return false; }
                        else { $.comment.up(this, commentid); }
                    });
                    a(this).find('.down').click(function () {
                        if (hearted == '1') { alert('不可重复踩'); return false; }
                        else { $.comment.down(this, commentid); }
                    });
                    a(this).find('.report').click(function () {
                        $.comment.report_pop(commentid);
                    });
                    a(this).find('.delete').click(function () {
                        $.comment.del(commentid);
                    });
                })
                a('blockquote').mouseover(function () {
                    a.comment.tool_show(this);
                }).mouseout(function () {
                    a.comment.tool_hide(this);
                });
                a.comment.face_img();
                a('.comment_list .hidebox').each(function(){
                    var hidebox =  a(this);
                    a(this).find('a').click(function(){
                        a(hidebox).hide();
                        a(hidebox).prevAll('blockquote').slideDown();
                    });
                });
            });
        },
        up: function (o, id) {
            if (!_login_check()) return;
            a.post(this.url, { act: 'up', comment: id },
			function (result) {
			    if (result.result == 'success') {
			        a(o).html('赞(' + result.num + ')').unbind("click");
			    } else if (result.result == 'unlog') {
			        _login();
			    }
			}, 'json');
        },
        down: function (o, id) {
            if (!_login_check()) return;
            a.post(this.url, { act: 'down', comment: id },
			function (result) {
			    if (result.result == 'success') {
			        a(o).html('踩(' + result.num + ')').unbind("click");
			    } else if (result.result == 'unlog') {
			        _login();
			    } else {

			    }
			}, 'json');
        },
        report_pop: function (id) {
            if (!_login_check()) return;
            report_open();
            a('.pop-body #btn_submit').unbind('click').click(function () {
                a.comment.report(id)
            });
        },
        report: function (id) {
            var cont = a('#report_cont').val();
            if (cont == '') { alert('\u8bf7\u586b\u5199\u4e3e\u62a5\u5185\u5bb9'); return; }
            else if (cont.length > 100) { alert('内容不可多于100字'); return; }
            a.post(this.url, { act: 'report', comment: id, cont: cont },
			function (result) {
			    if (result == 'success') {
			        report_close();
			        alert('\u63d0\u4ea4\u6210\u529f\uff0c\u611f\u8c22\u60a8\u7684\u652f\u6301');
			    } else if (result == 'unlog') {
			        _login();
			    } else { }
			});
        },
        face_load: function () {
            $.face.load(a('.reply_tool .face'));
        },
        face_show: function () {
            a('.reply_tool .face').toggle();
            a('.reply_tool .face img').click(function () {
                a('#reply_cont').insertContent(a(this).attr('title'));
            });
        },
        face_img: function () {
            a("blockquote .cont").each(function () {
                $.face.show(a(this));
            });
        },
        img_upload: function() {

        if (!_login_check()) return;
        
            popOpen(a('#jsUploadReply').html());
        },
        img_show: function (is, ib) {
            a('.reply_tool #reply_imgs').val(is + ',' + ib);
            a('.reply_tool #reply_img img').attr('src', is);
            a('.reply_tool .pic').show();
            popClose();
            a('.reply_tool .del').click(function(){
                a.comment.img_delete();
            });
        },
        img_delete: function () {
            a('.reply_tool #reply_imgs').val('');
            a('.reply_tool #reply_img img').attr('src', '');
            a(".reply_tool #reply_img").unbind("click");
            a('.toolcont .pic').hide();
        },
        comment: function () {
            var cont = a('#reply_cont').val();
            var imgs = a('#reply_imgs').val();
            if (cont == '' && imgs == '') {
                alert('请填写回复内容');
                return false;
            }
            if (cont.length > 2000) {
                alert('回复内容不可多于2000字');
                return false;
            }
            var replyid = a('#reply_id').val();
            a.post(this.url,
            { act: 'comment', info: this.articleid, reply: replyid, cont: a('#reply_cont').val(), imgs: imgs },
            function (result) {
                if (result == 'success') {
                    a.comment.list(1);
                    alert('\u63d0\u4ea4\u6210\u529f\uff0c\u611f\u8c22\u60a8\u7684\u652f\u6301');
                } else if (result == 'unlog') {
                    _login();
                } else {
                    alert('\u63d0\u4ea4\u5931\u8d25');
                }
            });
        },
        del: function(id){
            a.post(this.url, { act: 'delete', comment: id},
			function (result) {
			    if (result == 'success') {
			        a.comment.list(1);
			    }
			});
        }
    }
})(jQuery);
(function (a) {
    a.msg = {
        url: "../handlers/msg.ashx",
        pop: function (i, n) {
            if (!_login_check()) return;
            var _html = '<div id="pop_window"><div id="pop_content"><div class="pop_content_inner"></div></div></div><div id="pop_overlay" class="pop_overlay" onclick="pop_close()"></div>';
            a("body", "html").css({ height: "100%", width: "100%" });
            a("body").append(_html);
            a('.pop_content_inner').html($('#jsMsg').html());
            a('#msg_user').val(i);
            a('.to_user').html('TO：' + n);
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
                pop_close();
			    if (result == 'success') {
			        alert('\u53d1\u9001\u6210\u529f');
			    }
			});
        }
    }
})(jQuery);

(function (a) {
    a.face = {
        domain : 'http://www.cppfoto.com/face/',
        tags : ('微笑,撇嘴,色,发呆,得意,流泪,害羞,闭嘴,睡,大哭,尴尬,发怒,调皮,呲牙,惊讶,难过,酷,冷汗,抓狂,吐,偷笑,可爱,白眼,傲慢,饥饿,困,惊恐,流汗,憨笑,大兵,奋斗,咒骂,疑问,嘘,晕,疯了,衰,骷髅,敲打,再见,擦汗,抠鼻,鼓掌,糗大了,坏笑,左哼哼,右哼哼,哈欠,鄙视,委屈,快哭了,阴险,亲亲,吓,可怜,强,弱,握手,胜利,抱拳,勾引,拳头,差劲,爱你,NO,OK,猪头,玫瑰,凋谢,拥抱,示爱,爱心,心碎,刀,菜刀,炸弹,手枪,药,啤酒,咖啡,饭,下面,香蕉,西瓜,便便,蛋糕,足球,篮球,乒乓,发财,K歌,帅,月亮,太阳,多云,下雨,闪电,打伞,礼物,购物,邮件,钻戒,棒棒糖,喝奶,钞票,彩球,喝彩,风车,纸巾,祈祷,灯泡,闹钟,沙发,双喜,鞭炮,灯笼,爆筋,青蛙,招财猫,熊猫,瓢虫,飞机,开车,左车头,车厢,右车头').split(','),
        load: function (container) {
            var faces = '';    
            for (var i = 0; i < this.tags.length; i++) {
                faces += '<img src="' + this.domain + i + '.png" title="[' + this.tags[i] + ']" />';
            }
            container.html(faces);
        },
        show:function(container){
            var cont = container.html();
            for (var i = 0; i < this.tags.length; i++) {
                while (cont.indexOf('[' + this.tags[i] + ']') > 0) {
                    cont = cont.replace('[' + this.tags[i] + ']', '<img src="' + this.domain + i + '.png" title="' + this.tags[i] + '" align="absmiddle" />')
                }
            }
            container.html(cont);
        }
    }
})(jQuery);
$(document).ready(function () {
    $(function () {
        $('#photoView').hover(function () {
            $('#cont').fadeIn(); 
        }, function () {
            $('#cont').fadeOut();
        });
    });
    $('#photoView').mouseover(function () {
        var cont = $('.photo_show').eq(cur).find('.cont');
        if (cont.find('.text').html() != '') { $(cont).show() }
        $('.bigOpen').show()
        p = false;
    }).mouseout(function () {
        $('.photo_show').eq(cur).find('.cont').hide();
        $('.bigOpen').hide()
        p = true;
    });
    $('.photo').load(function () {
        $('.photoView').height($(this).parent('.photo_show').height());
    });
    $('.imgs a').each(function (i) {
        $(this).click(function () {
            showPhoto(i);
            cur = i;
            showVideo(false);
        });
    });
    $('#photoPrev').click(function () {
        showVideo(false);
        if (cur > 0) {
            cur--;
            showPhoto(cur);
        }
    });
    $('#photoNext').click(function () {
        showVideo(false);
        if (cur < ln - 1) {
            cur++;
            showPhoto(cur);
        }
    });
    $('.video').click(function () {
        showVideo(true);
    });
    $('.bigOpen').click(function () {
        window.open('picture.aspx?id=' + $('.photo_show').eq(cur).find('.photo').attr('data_id'));
    });
    if (ln == 0 && $('.video').length > 0) {
        showVideo(true);
    } else if (ln == 0 && $('.video').length == 0) {
        $('.big_img').hide();
    }

    $.info.initial();
    $.comment.list(1);
});
function showPhoto(ind) {
    cur = ind;
    $('.photoView').height($('.photo_show').eq(ind).height());
    $('.photo_show').fadeOut('slow').eq(ind).fadeIn('slow');
    $('.imgs img').removeClass('cur').eq(ind).addClass('cur');
}
function showVideo(b) {
    var _video = '';
    if ($('.video').length > 0) {
        _video = $('.video').attr('video')
    }
    var _html = "<embed type='application/x-shockwave-flash' src='" + _video + "' width='860' height='600' flashvars='isAutoPlay=true&winType=interior' quality='high' allowscriptaccess='always' allowfullscreen='true' />";
    if (b) {
        $('#movie_player').show().html(_html);
        $('#photoView').hide();
    } else {
        $('#movie_player').hide().html('');
        $('#photoView').show();
    }
}
function report_open() {
    var _html = '<div id="pop_window"><div id="pop_content"><div class="pop_content_inner"></div></div></div><div id="pop_overlay" class="pop_overlay" onclick="pop_close()"></div>';
    $("body", "html").css({
        height: "100%",
        width: "100%"
    });
    $("body").append(_html);
    $('.pop_content_inner').html($('#jsReport').html());
}
function report_close() {
    $("#pop_window").remove();
    $("#pop_overlay").remove();
}
