Vue.component("myheader",{
    props:[
        'searchtxt','search'
    ],
    template:
    `
    <div class="header clearfix" id="myheader">
    <div class="logo fl">
        <a href="/" hidefocus="hidefocus"><img src="./images/info/logo.png"></a>
    </div>
    <div class="nav fl">
    <ul>
    <li><a href="/" hidefocus="hidefocus">首页</a></li>
    <li style="display:none;"><a href="/mall/" hidefocus="hidefocus">电商</a></li>
    <li><a href="/view.html" hidefocus="hidefocus">看点</a></li>
    <li class="cur"><a href="/info.html" hidefocus="hidefocus">圈子</a></li>
    <li><a href="/video.html" hidefocus="hidefocus">视听</a></li>
    </ul>
    </div>
    <div class="search fl">
    <div class="search-con">
    <input id="search" class="_input_key glyphicon glyphicon-search" type="text" value="" placeholder="圈子内容搜索" v-model="searchtxt">
    <i class="glyphicon glyphicon-search" style="position: absolute;top: 10px; font-size: 2rem;" @click="search()"></i>
    </div>
    </div>
    <div class="login fr"><a href="/register.html" hidefocus="hidefocus">注册</a><a href="login.html" hidefocus="hidefocus">登录</a></div>
    </div>
    `
})

let vm_header=new Vue({
        el:"#myheader",
        data:{
            searchtxt:''
        },
        methods:{
            search(){
                let searchText=$('#search').val()
                //let searchText=vm_header.searchtext;
                if(searchText==''){
                    alert('搜索内容不能为空');
                    return;
                }
                location.href='/info.html?searchText='+searchText;
            }
        },
        created(){

        },
    })