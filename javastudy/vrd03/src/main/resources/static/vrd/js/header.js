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