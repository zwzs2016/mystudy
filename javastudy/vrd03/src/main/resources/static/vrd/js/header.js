Vue.component('myheader',{
    props:[
        "categories",
        "wd",
        "isLogin",
        "logout",
        "findById",
        "search"
    ],
    template:
    `
      <div id="vm_header">
        <header class="container">
          <!--导航条开始-->
          <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">
                  <img alt="Brand" src="images/logo.png">
                </a>
              </div>
              <!--首页和分类-->
              <ul class="nav navbar-nav">
                <li><a href="home.html">首页</a></li>
    <!--            <li v-for="c in categories"><a href="#" v-text="c.name" @click="findById(c.id)"></a></li>-->
                <li v-for="c in categories"><a :href="'home.html?cid='+c.id" v-text="c.name"></a></li>
                <li>
    <!--              文本框敲回车自动提交-->
    <!--              form表单的提交事件是提交事件-->
    <!--              事件添加prevent阻止事件触发-->
                  <form action="" @submit.prevent>
                    <input type="text" placeholder="Search" v-model="wd" @keyup.enter="search(wd)">
                    <button>
                      <a :href="'home.html?wd='+wd" class="fa fa-search"></a>
                    </button>
                  </form>
                </li>
              </ul>
              <!--右侧内容-->
              <ul class="nav navbar-nav navbar-right">
                <li ><a class="fa fa-user-circle" href="send.html">发布作品</a></li>
                <li v-if="isLogin"><a class="fa fa-user-circle" href="banner.html">轮播图</a></li>
                <li v-if="!isLogin"><a id="login_a" class="fa fa-user-circle" href="login.html">管理员入口</a></li>
                <li v-if="isLogin"><a id="logout_a" class="fa fa-user-circle" href="#" @click="logout">登出</a></li>
              </ul>
            </div>
          </nav>
          <!--导航条结束-->
        </header>
  </div>  
    `
})


let head_vm=new Vue({
    el:"#vm_header",
    data:{
        categories:[],
        wd:'',
        isLogin:false
    },
    methods:{
      logout(){
          if(confirm("您确定退出登录吗？")){
              axios.get("/logout").then(function (response) {
                  location.reload();//刷新页面
                  head_vm.isLogin=true;
              })
          }
      },
      findById(id){
          //通过分类id发异步请求
          axios.get("/findbycid?id="+id).then(function (response) {
                if (response.data){
                    vm_product.product_arr=response.data;
                    $(".grid").imagesLoaded().progress(function () {
                        // $(".grid").masonry("layout");//让瀑布流框架重新计算元素位置
                        //瀑布流初始化代码
                        $(".grid").masonry({
                            itemSelector:".grid-item",//告诉瀑布流框架 如何找到瀑布流里面的元素
                            columnWidth:210  //设置瀑布流元素每一列所占宽度(元素宽度200+间距10)
                        });
                    });
                }
          })
      },
      search(wd){
          location.href='home.html?wd='+wd;
      }
    },
    created(){
        //发出获取所有分类
        axios.get("/selectcategory").then(function (response) {
            head_vm.categories=response.data;
        });
        axios.get("/checklogin").then(function (response) {
            head_vm.isLogin=response.data;
        });
    }
})