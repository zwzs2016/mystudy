(function (a) {
    a.info = {
        url: "../handlers/info.ashx",
        initial: function () {
            a('.cate a').click(function () {
                a('.cate a').removeClass();
                a(this).addClass('sel');
                a('#hfCategory').val(a(this).attr('value'));
            });
            a('.cate a[value="' + $('#hfCategory').val() + '"]').addClass('sel');
            a('.upload-img a').click(function () {
                a.info.pop();
            });
            a.info.img_intial();
            if (a('.videolink').val() != '') a('.vbox').show();
        },
        pop: function () {
            pop_open();
            var ifm = document.getElementById('ifmUpload');
            if (ifm != null) {
                ifm.height = 380;
                ifm.width = 400;
            }
            $(".pop").css("left", "50%");
        },
        imgs: function () {
            $(".img").load("infoimgs.aspx?ids=" + a('#hfImgs').val());
        },
        img_check: function () {

        },
        img_intial: function () {
            a('.imgs input').blur(function (i) {
                var descs = '';
                a('.imgs input').each(function () {
                    descs += a(this).val().replace(',', '，') + ',';
                });
                a('#hfDescs').val(descs.substr(0, descs.length - 1));
            });
            a('.img a').click(function (i) {
                a(this).siblings('img').attr('src', '../images/o.gif');
                a(this).siblings('input').val(0);
            });
        },
        img_add: function (i, url) {
            var html = "<li class='img" + i + "'><b><img src='" + url + "' /></b><input type='text' value='' /><a href='javascript:;' onclick='$.info.img_delete(" + i + ");'>删除</a></li>";
            if (a('#hfImgs').val() == '') {
                a('#hfImgs').val(i)
            } else {
                a('#hfImgs').val(a('#hfImgs').val() + ',' + i)
            }
            a('.imgs').append(html);
            pop_close();
            a.info.img_intial();
        },
        img_delete: function (i) {
            a('#hfImgs').val($.grep(a('#hfImgs').val().split(','), function (n, v) { return n != i }).join())
            a('#hfDescs').val($.grep(a('#hfDescs').val().split(','), function (n, v) { return n != i }).join())
            a('.img' + i).remove();
            //a.info.imgs();
        },
        check: function () {
            if (a('#hfCategory').val() == '0' || a('#hfCategory').val() == '') {
                alert('请选择标签'); return false;
            }
            if (a('input[type="file"]').val() == '') {
                alert('请上传图片'); return false;
            }
            if (a('#txtTitle').val() == '') {
                alert('填写填写标题'); return false;
            }

            var descs = '';
            a('.imgs input').each(function () {
                descs += a(this).val().replace(',', '，') + ',';
            });
            a('#hfDescs').val(descs.substr(0, descs.length - 1));
            //alert(a('#hfDescs').val() + ':' + a('#hfDescs').val().split(',').length + ":" + a('#hfImgs').val().split(',').length);
            if (a('#hfDescs').val().split(',').length != a('#hfImgs').val().split(',').length) {
                return false;
            }
            this.disabled = true;
            return true;
        },
        info_delete: function (id) {
            a.post(this.url, { act: 'info_delete', id: id }, function (result) { if (result == 'success') location.reload(); else alert('\u64cd\u4f5c\u5931\u8d25'); });
        },
        comment_delete: function (id) {
            a.post(this.url, { act: 'comment_delete', id: id }, function (result) { if (result == 'success') location.reload(); else alert('\u64cd\u4f5c\u5931\u8d25'); });
        },
        favorite_delete: function (id) {
            a.post(this.url, { act: 'favorite_delete', id: id }, function (result) { if (result == 'success') location.reload(); else alert('\u64cd\u4f5c\u5931\u8d25'); });
        }
    }
})(jQuery);
(function (a) {
    a.face = {
        domain: 'http://www.cppfoto.com/face/',
        tags: ('微笑,撇嘴,色,发呆,得意,流泪,害羞,闭嘴,睡,大哭,尴尬,发怒,调皮,呲牙,惊讶,难过,酷,冷汗,抓狂,吐,偷笑,可爱,白眼,傲慢,饥饿,困,惊恐,流汗,憨笑,大兵,奋斗,咒骂,疑问,嘘,晕,疯了,衰,骷髅,敲打,再见,擦汗,抠鼻,鼓掌,糗大了,坏笑,左哼哼,右哼哼,哈欠,鄙视,委屈,快哭了,阴险,亲亲,吓,可怜,强,弱,握手,胜利,抱拳,勾引,拳头,差劲,爱你,NO,OK,猪头,玫瑰,凋谢,拥抱,示爱,爱心,心碎,刀,菜刀,炸弹,手枪,药,啤酒,咖啡,饭,下面,香蕉,西瓜,便便,蛋糕,足球,篮球,乒乓,发财,K歌,帅,月亮,太阳,多云,下雨,闪电,打伞,礼物,购物,邮件,钻戒,棒棒糖,喝奶,钞票,彩球,喝彩,风车,纸巾,祈祷,灯泡,闹钟,沙发,双喜,鞭炮,灯笼,爆筋,青蛙,招财猫,熊猫,瓢虫,飞机,开车,左车头,车厢,右车头').split(','),
        load: function (container) {
            var faces = '';
            for (var i = 0; i < this.tags.length; i++) {
                faces += '<img src="' + this.domain + i + '.png" title="[' + this.tags[i] + ']" />';
            }
            container.html(faces);
        },
        show: function (container) {
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
    $(".my-comments .con-1").each(function () {
        $.face.show($(this));
    });
});