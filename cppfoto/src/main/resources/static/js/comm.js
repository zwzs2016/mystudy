var logindiv=
`
<div class="user fr">
	<div class="dropdown-wrap">
		<a class="poartrait" href="/user/profile.html" hidefocus="hidefocus">
		<img src="/images/info/portrait.jpg"></a><ul><li style="display:none;">
		<a href="/mall/cart.html" hidefocus="hidefocus">
		<i class="icon-1"></i>购物车<b class="_cart_num">0</b></a></li><li>
		<a href="/user/coins.html" hidefocus="hidefocus">
		<i class="icon-2"></i>账户中心</a></li><li><a href="/user/msgs.html" hidefocus="hidefocus">
		<i class="icon-3"></i>站内消息</a></li><li><a href="/user/consults.html" hidefocus="hidefocus">
		<i class="icon-8"></i>我的咨询</a></li><li><a href="/user/workses.html" hidefocus="hidefocus">
		<i class="icon-4"></i>我的作品</a></li><li><a href="/user/infos.html" hidefocus="hidefocus"><i class="icon-5"></i>我的文章</a>
		</li><li><a href="/user/infocomments.html" hidefocus="hidefocus"><i class="icon-8"></i>圈子评论</a></li>
		<li><a href="/user/videocomments.html" hidefocus="hidefocus"><i class="icon-8"></i>视听评论</a></li><li>
		<a href="/user/favorites.html" hidefocus="hidefocus"><i class="icon-6"></i>我的收藏</a></li><li><a href="/user/infos.html" hidefocus="hidefocus">
		<i class="icon-7"></i>最新资讯</a></li></ul></div>
		<div class="info">
		<span class="hello">
		<a href="javascript:;" onclick="logout()" hidefocus="hidefocus">[退出]</a></span>
		<div class="rank">学前班</div>
		</div>
</div>
`;
var indexdiv=
`
<div class="user fr">
<a class="poartrait" href="/user/profile.html" hidefocus="hidefocus">
<img src="/images/info/portrait.jpg"></a>
<div class="info">
<span class="hello">
<a href="javascript:;" onclick="logout()" hidefocus="hidefocus">[退出]</a></span>
<span class="level">学前班</span>
</div>
</div>
`

//logout
var logoutdiv=`
<div class="login fr">
    <a href="../register.html" hidefocus="hidefocus">注册</a>
    <a href="../login.html?from=/info/" hidefocus="hidefocus">登录</a>
</div>
`;

var userinfo=`
&nbsp;&nbsp;<em>学前班</em>
`;
function logout() {
    axios.get("/logout").then(function (res) {
        console.log(res)
        if (res.status==200){
            alert("退出成功!");
            $(".user").remove();
            $(".header").append($(logoutdiv));
            location.href='/';
        }
    })
}
function dateFmt(value){
    if(null!=value&&""!=value){
        var date = new Date(value);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        if(m<10){
            m="0"+m;
        }
        var d = date.getDate();
        if(d<10){
            d="0"+d;
        }
        return y + '-' +m + '-' + d;
    }else{
        return "";
    }
}
$(function () {
    axios.get("/islogin").then(function (res) {
        if(res.data){
            let user=res.data;
            $(".login").remove();
            if(location.href.indexOf("html")==-1){
                $(".header").append(indexdiv);
            }else {
                $(".header").append(logindiv);
            }

            $(".user .hello").prepend("<span>"+user.username+"</span>");
            $(".user-name").html(user.username+userinfo);
        }else {
            alert('您还未登录!')
            location.href='/login.html';
        }
    });

    //获取图片
    axios.get("/portrait/selectimg").then(function (res) {
        if(res.data){
            let img=res.data;
            $("#portrait").attr('src',img.imgUrl);
            $(".user-img img").attr('src',img.imgUrl);
            $(".poartrait img").attr('src',img.imgUrl);
        }
    })

})