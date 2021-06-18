let head_vm=new Vue({
    el:"#vm_header",
    data:{
        categories:[],
        isLogin:false
    },
    methods:{
      logout(){
          if(confirm("您确定退出登录吗？")){
              axios.get("/logout").then(function (response) {
                  head_vm.isLogin=true;
              })
          }
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