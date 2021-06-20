$(document).ready(function () {
            
      $.reg.initial();
     
});

(function(a) {


    a.reg = {
        url: "../handlers/reg.ashx",
        initial: function() {
            a('.verify-code').click(function() { a.reg.sms(); });
            a('.step1').click(function() { a.reg.verify(); });
            a('.step2').click(function() { a.reg.register(); });
            a('.step3').click(function() { location.href = '/' });
            a('.agreement').click(function() { pop_open(); $('.pop-body').load('html/agreement.htm?cppfoto'); });
            a('.submit').click(function() { a.reg.submit(); });
            a('.username').blur(function() { a.reg.username(); });
            a('.pwd').blur(function() { a.reg.pwd(); });
            a('.confirm').blur(function() { a.reg.confirm(); });
            a('.mobile').blur(function() { a.reg.mobile(); });
            a('.picVcode').blur(function() { if (a.reg.picVcode()) a.reg.picVerify(); });
            a('.vcode').blur(function() { if (a.reg.vcode()) a.reg.verify(); });

            a('.email').blur(function() { a.reg.email(); });
            a('.realname').blur(function() { a.reg.realname(); });
            a('.birth').blur(function() { a.reg.birth(); });
            a('.company').blur(function() { a.reg.company(); });
            a('.region').blur(function() { a.reg.region(); });
            a('.address').blur(function() { a.reg.address(); });
            a('.postcode').blur(function() { a.reg.postcode(); });
            a("#province").change(function() { region.changed('city', a(this), 'city'); a('#region').val(''); });
            a("#city").change(function() { region.changed('district', a(this), 'district'); a('#region').val(''); });
            a("#district").change(function() { a('#region').val(a(this).val()); });



        },
        step: function(i) {
            a('.content-con').hide(); a('.regist' + i).show();
            if (i == 1) { a('.login').show() } else { a('.login').hide() }
        },
        sms: function() {


            var im = a('.mobile');
            var iv = a('.picVcode');


            if (countdown < 60) return;

            if (a(iv).val() == '') {
                a(iv).siblings('span').addClass('err').html('\u8bf7\u586b\u5199\u9a8c\u8bc1\u7801'); return;
            }
            if (!$.f.isMobile(a(im).val())) {
                a(im).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7'); return;
            }

         //   if (slideVerify.slideFinishState == false) {
           //     alert('滑动验证不正确');
          //      return;
         //   }
            a.post(
                this.url,
                { act: 'sms', mobile: a(im).val(), vcode: a(iv).val(), com: a('.company').val(), email: a('.email').val() },
                function(result) {

                  
                    if (result == 'success') {
                        alert("手机验证码发送成功!");
                        settime(document.getElementById('btnVerify'));
                        $('#imgVCode').attr('src', '../ajax/vcode.ashx?action=register&guid=' + new Date());
                    } else if (result == 'exist') {
                        a(im).siblings('span').addClass('err').html('\u6b64\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c'); return;
                    }
                    else if (result == 'vcode') {

                        a(iv).siblings('span').addClass('err').html('图片验证码不正确'); return;
                    }
                    else if (result == 'limitedMax') {
                        a(im).siblings('span').addClass('err').html('手机验证码发送超出限制，请稍后再试！'); return;
                    }
                    else if (result == 'limitedMin') {
                        a(im).siblings('span').addClass('err').html('每分钟只允许发送一条短信，请稍后再试'); return;
                    }
                    else if (result == 'limitedMobile') {
                        a(im).siblings('span').addClass('err').html('每10分钟内最多允许发送3条短信'); return;
                    }
                    else if (result == 'limitedIp') {
                        a(im).siblings('span').addClass('err').html('发送的短信超出了IP限制'); return;
                    }
                    else {
                        alert('发送失败');
                    }
                }
            );
        },
        verify: function() {
            var im = a('.mobile'); var iv = a('.verify');
            if (!$.f.isMobile(a(im).val())) {
                a(im).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7'); return;
            } else {
                a(im).siblings('span').removeClass('err').html('');
            }
            if (a(iv).val() == '') {
                a(iv).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801'); return;
            } else {
                a(iv).siblings('span').removeClass('err').html('');
            }
            a.post(
                this.url,
                { act: 'verify', mobile: a(im).val(), vcode: a(iv).val() },
                function(result) {
                    if (result == 'success') {
                        a(iv).siblings('span').removeClass('err').html('');
                        //a.reg.step(2); 
                    } else {
                        a(iv).siblings('span').addClass('err').html('\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e');
                    }
                }
            );
        },
        picVerify: function() {
            var iv = a('.picVerify');
            if (a(iv).val() == '') {
                a(iv).siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801'); return;
            } else {
                a(iv).siblings('span').removeClass('err').html('');
            }
            a.post(
                this.url,
                { act: 'picVerify', vcode: a(iv).val() },
                function(result) {

                    if (result == 'success') {
                        a(iv).siblings('span').removeClass('err').html('');
                    } else {

                        a(iv).siblings('span').addClass('err').html('\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e');
                    }
                }
            );
        },
        getByteLen: function(val) {
            var len = 0;
            for (var i = 0; i < val.length; i++) {
                var length = val.charCodeAt(i);
                if (length >= 0 && length <= 128) {
                    len += 1;
                }
                else {
                    len += 2;
                }
            }
            return len;
        },
        username: function() {
            var username = a('.username').val();
            if (username == '') {
                a('.username').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u7528\u6237\u540d'); return false;
            } else if (!$.f.isName(username) || a.reg.getByteLen(username) < 4 || a.reg.getByteLen(username) > 20) {
                a('.username').siblings('span').addClass('err').html('请输入4-20位数字、字母或2位及以上中文组成的用户名'); return false;
            } else {
                a('.username').siblings('span').removeClass('err').html(''); return true;
            }
        },
        pwd: function() {
            if (a('.pwd').val() == '') {
                a('.pwd').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u767b\u5f55\u5bc6\u7801'); return false;
            } else if (a('.pwd').val().length < 6 || a('.pwd').val().length > 20) {
                a('.pwd').siblings('span').addClass('err').html('\u8bf7\u8f93\u51656-20\u4f4d\u5bc6\u7801'); return false;
            } else {
                a('.pwd').siblings('span').removeClass('err').html(''); return true;
            }
        },
        confirm: function() {
            if (a('.confirm').val() == '') {
                a('.confirm').siblings('span').addClass('err').html('\u8bf7\u518d\u6b21\u8f93\u5165\u767b\u5f55\u5bc6\u7801'); return false;
            } else if (a('.confirm').val() != a('.pwd').val()) {
                a('.confirm').siblings('span').addClass('err').html('\u4e24\u6b21\u8f93\u5165\u5bc6\u7801\u4e0d\u4e00\u81f4'); return false;
            } else {
                a('.confirm').siblings('span').removeClass('err').html(''); return true;
            }
        },
        mobile: function() {
            if (a('.mobile').val() == '') {
                a('.mobile').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u624b\u673a\u53f7'); return false;
            } else if (!$.f.isMobile(a('.mobile').val())) {
                a('.mobile').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7'); return false;
            } else {
                a('.mobile').siblings('span').removeClass('err').html(''); return true;
            }
        },
        vcode: function() {
            if (a('.vcode').val() == '') {
                a('.vcode').siblings('span').addClass('err').html('\u8bf7\u83b7\u53d6\u5e76\u586b\u5199\u9a8c\u8bc1\u7801'); return false;
            } else {
                a('.vcode').siblings('span').removeClass('err').html(''); return true;
            }
        },
        picVcode: function() {
            if (a('.picVcode').val() == '') {
                a('.picVcode').siblings('span').addClass('err').html('\u8bf7\u586b\u5199\u9a8c\u8bc1\u7801'); return false;
            } else {
                a('.picVcode').siblings('span').removeClass('err').html(''); return true;
            }
        },
        email: function() {
            if (a('.email').val() == '') {
                a('.email').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u5e38\u7528\u90ae\u7bb1'); return false;
            } else if (!$.f.isEmail(a('.email').val())) {
                a('.email').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7bb1'); return false;
            } else {
                a('.email').siblings('span').removeClass('err').html(''); return true;
            }
        },
        realname: function() {
            if (a('.realname').val() == '') {
                a('.realname').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u59d3\u540d'); return false;
            } else {
                a('.realname').siblings('span').removeClass('err').html(''); return true;
            }
        },
        birth: function() {
            if (a('.birth').val() == '') {
                a('.birth').siblings('span').addClass('err').html('\u8bf7\u8f93\u5165\u751f\u65e5'); return false;
            } else {
                a('.birth').siblings('span').removeClass('err').html(''); return true;
            }
        },
        company: function() {
            if (a('.company').val() == '') {
                a('.company').siblings('span').addClass('err').html('请输入工作单位或所在院校'); return false;
            } else {
                a('.company').siblings('span').removeClass('err').html(''); return true;
            }
        },
        region: function() {
            if (a('.region').val() == '' || a('.region').val() == '0') {
                a('.region').siblings('span').addClass('err').html('\u8bf7\u9009\u62e9\u6240\u5728\u5730\u533a'); return false;
            } else if (a('.region').val() != a('#district').val()) {
                a('.region').siblings('span').addClass('err').html('\u8bf7\u9009\u62e9\u6240\u5728\u533a\u53bf'); return false;
            } else {
                a('.region').siblings('span').removeClass('err').html(''); return true;
            }
        },
        address: function() {
            if (a('.address').val() == '') {
                a('.address').siblings('span').addClass('err').html('\u8bf7\u586b\u5199\u8be6\u7ec6\u8054\u7cfb\u5730\u5740'); return false;
            } else {
                a('.address').siblings('span').removeClass('err').html(''); return true;
            }
        },
        postcode: function() {
            if (a('.postcode').val() == '') {
                a('.postcode').siblings('span').addClass('err').html('\u8bf7\u586b\u5199\u90ae\u7f16'); return false;
            } else {
                a('.postcode').siblings('span').removeClass('err').html(''); return true;
            }
        },
        agree: function() {
            if (!$('.agree').is(":checked")) {
                a('.agree').siblings('span').addClass('err').html('请仔细阅读用户协议并同意后才可以注册'); return false;
            } else {
                a('.agree').siblings('span').removeClass('err').html(''); return true;
            }
        },
        submit: function() {
            var ok = true;
            var br = a('.step3');
            ok = a.reg.username() == true ? ok : false;
            ok = a.reg.pwd() == true ? ok : false;
            ok = a.reg.confirm() == true ? ok : false;
            ok = a.reg.mobile() == true ? ok : false;
            ok = a.reg.vcode() == true ? ok : false;
            ok = a.reg.email() == true ? ok : false;
            ok = a.reg.realname() == true ? ok : false;
            ok = a.reg.birth() == true ? ok : false;
            ok = a.reg.company() == true ? ok : false;
            ok = a.reg.region() == true ? ok : false;
            ok = a.reg.address() == true ? ok : false;
            ok = a.reg.postcode() == true ? ok : false;
            ok = a.reg.agree() == true ? ok : false;
            if (!ok) { return; }
            a.post(
                this.url,
                {
                    act: 'register',
                    username: a('.username').val(),
                    pwd: a('.pwd').val(),
                    confirm: a('.confirm').val(),
                    mobile: a('.mobile').val(),
                    vcode: a('.verify').val(),
                    email: a('.email').val(),
                    realname: a('.realname').val(),
                    sex: (a('.sex1').is(":checked") == true ? '男' : '女'),
                    birth: a('.birth').val(),
                    company: a('.company').val(),
                    tel: a('.tel').val(),
                    region: a('.region').val(),
                    address: a('.address').val(),
                    postcode: a('.postcode').val(),
                    canmerabrand: a('.canmerabrand').val(),
                    canmeramodel: a('.canmeramodel').val()
                },
                function(result) {
                    if (result == 'success') {
                        a('.warn').hide().html('');
                        a.reg.step(3);
                        intervalid = setInterval("go()", 1000);
                    } else if (result == 'vcode') {
                        a('.warn').show().html('\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e');
                    } else if (result == 'confirm') {
                        a('.warn').show().html('\u4e24\u6b21\u8f93\u5165\u5bc6\u7801\u4e0d\u6b63\u786e');
                    } else if (result == 'username') {
                        a('.warn').show().html('\u6b64\u7528\u6237\u540d\u5df2\u88ab\u6ce8\u518c');
                    } else if (result == 'mobile') {
                        a('.warn').show().html('\u6b64\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c');
                    } else if (result == 'email') {
                        a('.warn').show().html('\u6b64\u90ae\u7bb1\u5df2\u88ab\u6ce8\u518c');
                    } else {
                        a('.warn').show().html('\u6ce8\u518c\u5931\u8d25');
                    }
                }
            );
        }
    }
})(jQuery);


var countdown = 60;
var timer1;
function settime(val) {
    if (countdown == 0) {
        $(val).removeClass('dis');
        val.removeAttribute("disabled");
        $(val).html("\u53d1\u9001\u9a8c\u8bc1\u7801");
        countdown = 60;
        clearTimeout(timer1);
    } else {
        $(val).addClass('dis');
        $(val).attr('disabled','disabled');
        $(val).html("\u91cd\u65b0\u53d1\u9001(" + countdown + ")");
        countdown--;
        timer1 = setTimeout(function () { settime(val); }, 1000);
    }
}

var remain = 5;
var intervalid;
function go() {
    if (remain == 0) {
        window.location.href = "../user/profileedit.aspx";
        clearInterval(intervalid);
    }
    $(".mes").html(remain);
    remain--;
} 

