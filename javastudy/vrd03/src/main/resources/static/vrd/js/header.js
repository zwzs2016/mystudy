let head_vm=new Vue({
    el:"#vm_header",
    data:{
        categories:[]
    },
    created(){
        //发出获取所有分类
        axios.get("/selectcategory").then(function (response) {
            head_vm.categories=response.data;
        })
    }
})