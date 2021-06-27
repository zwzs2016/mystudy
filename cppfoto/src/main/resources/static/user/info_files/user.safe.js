(function (a) {
    a.safe = {
        url: "../handlers/safe.ashx",
        initial: function () {

        },
        pwd_pop: function () {
            pop_open();
            a('#ifmSafe').attr('src', 'pwd.html')
        },
        pwd_check: function () {
            var io = a('#txtOld'), ip = a('#txtPwd'), ic = a('#txtConfirm');
            if (a(io).val() == '') {
                a(io).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u539f\u5bc6\u7801');
                return false;
            } else {
                a(io).siblings('span').removeClass('error').html('');
            }
            if (a(ip).val() == '') {
                a(ip).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801');
                return false;
            } else if (a(ip).val().length < 6 || a(ip).val().length > 20) {
                a(ip).siblings('span').addClass('error').html('\u8bf7\u8f93\u51656-20\u4f4d\u5bc6\u7801');
                return false;
            } else if (a(io).val() == a(ip).val()) {
                a(ip).siblings('span').addClass('error').html('\u65b0\u5bc6\u7801\u4e0d\u80fd\u4e0e\u65e7\u5bc6\u7801\u4e00\u6837');
                return false;
            } else {
                a(ip).siblings('span').removeClass('error').html('');
            }
            if (a(ic).val() == '') {
                a(ic).siblings('span').addClass('error').html('\u8bf7\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801');
                return false;
            } else if (a(ic).val() != a(ip).val()) {
                a(ic).siblings('span').addClass('error').html('\u4e24\u6b21\u8f93\u5165\u5bc6\u7801\u4e0d\u4e00\u81f4');
                return false;
            } else {
                a(ic).siblings('span').removeClass('error').html('');
            }
        },
        email_pop: function (act) {
            pop_open();
            a('#ifmSafe').attr('src', 'email.aspx?act=' + act)
        },
        email_send: function () {
            if (countdown < 60) return;
            var ie = $('#txtEmail');
            if (a(ie).val() == '') {
                a(ie).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7bb1');
                return false;
            } else if (!$.f.isEmail(a(ie).val())) {
                a(ie).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7bb1');
                return false;
            } else {
                a(ie).siblings('span').removeClass('error').html('');
            }
            $.ajax({
                url: this.url,
                type: "GET", cache: false, async: false,
                data: { act: 'email_send', email: a(ie).val() },
                success: function (result) {
                    if (result == 'success') {
                        a(ie).siblings('span').removeClass('error').html('\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u6ce8\u610f\u67e5\u6536');
                        settime(document.getElementById('bsend'));
                    } else if (result == 'exist') {
                        a(ie).siblings('span').addClass('error').html('\u6b64\u90ae\u7bb1\u5df2\u88ab\u6ce8\u518c');
                        return false;
                    } else {
                        a(ie).siblings('span').addClass('error').html('\u53d1\u9001\u5931\u8d25');
                        return false;
                    }
                },
                error: function () { alert('http error'); }
            });
        },
        email_verify: function () {
            var ie = $('#txtEmail');
            var ic = $('#txtCode');
            if (a(ie).val() == '') {
                a(ie).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u90ae\u7bb1');
                return false;
            } else if (!$.f.isEmail(a(ie).val())) {
                a(ie).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7bb1');
                return false;
            } else {
                a(ie).siblings('span').removeClass('error').html('');
            }
            if (a(ic).val() == '') {
                a(ic).siblings('span').addClass('error').html('\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801');
                return false;
            }
            $.ajax({
                url: this.url,
                type: "GET", cache: false, async: false,
                data: { act: 'email_verify', email: a(ie).val(), vcode: a(ic).val() },
                success: function (result) {
                    if (result == 'success') {
                        parent.location.reload();
                    } else if (result == 'vcode') {
                        a(ic).siblings('span').addClass('err').html('\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e');
                    } else {
                        a(im).siblings('span').addClass('err').html('\5cu9a8c\5cu8bc1\5cu5931\5cu8d25');
                    }
                }
            });
        },
        mobile_pop: function (act) {
            pop_open();
            a('#ifmSafe').attr('src', 'mobile.aspx?act=' + act)
        },
        mobile_send: function () {
            if (countdown < 60) return;
            var im = $('#txtMobile');
            if (!$.f.isMobile(a(im).val())) {
                a(im).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7');
                return false;
            } else {
                a(im).siblings('span').removeClass('err').html('');
            }
            $.ajax({
                url: this.url,
                type: "GET", cache: false, async: false,
                data: { act: 'mobile_send', mobile: a(im).val() },
                success: function (result) {
                    if (result == 'success') {
                        a(im).siblings('span').html('\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u6ce8\u610f\u67e5\u6536');
                        settime(document.getElementById('bsend'));
                    } else if (result == 'exist') {
                        a(im).siblings('span').addClass('err').html('\u6b64\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c');
                    }
                    else if (result == 'limitedMax') {
                        a(im).siblings('span').addClass('err').html('每个手机号每天最多允许发送5条短信。'); return;
                    }
                    else if (result == 'limitedMin') {
                    a(im).siblings('span').addClass('err').html('每分钟只允许发送一条短信，请稍后再试。'); return;

                }
                else if (result == 'limitedMobile') {
                    a(im).siblings('span').addClass('err').html('每10分钟内最多允许发送3条短信'); return;
                }
                    else {
                        a(im).siblings('span').addClass('err').html('\u9a8c\u8bc1\u7801\u53d1\u9001\u5931\u8d25');
                    }
                }
            });
        },
        mobile_verify: function () {
            var im = $('#txtMobile');
            var ic = $('#txtCode');
            if (a(im).val() == '') {
                a(im).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u624b\u673a\u53f7');
                return false;
            } else if (!$.f.isMobile(a(im).val())) {
                a(im).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7');
                return false;
            }
            if (a(ic).val() == '') {
                a(ic).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801');
                return false;
            }
            $.ajax({
                url: this.url,
                type: "GET", cache: false, async: false,
                data: { act: 'mobile_verify', mobile: a(im).val(), vcode: a(ic).val() },
                success: function (result) {
                    if (result == 'success') {
                        parent.location.reload();
                    } else if (result == 'vcode') {
                        a(ic).siblings('span').addClass('err').html('\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e');
                    } else {
                        a(im).siblings('span').addClass('err').html('\5cu9a8c\5cu8bc1\5cu5931\5cu8d25');
                    }
                }
            });
        }
    }
})(jQuery);
