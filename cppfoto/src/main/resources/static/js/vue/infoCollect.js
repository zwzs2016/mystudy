var categoryId=0;
let vm_infoCollect=new Vue({
    el:"form",
    data:{
        category_arr:[],
        categoryId:0
    },
    created(){
        axios.get("/category?directory=报纸征集").then(function (res) {
            if(res.data){
                vm_infoCollect.category_arr=res.data;
            }
        })
    },
    updated(){
        $(".form-con a").click(function () {
            categoryId=$(this).attr('value');
            vm_infoCollect.categoryId=categoryId;
            $(this).css({background: '#f00',border: 'solid 1px #f00',color: '#fff'});
            $(this).siblings().css({background: '#fff',border: 'solid 1px #DFDFDF',color: '#000'})
            $("#hfCategory").val(categoryId);
        })
    }
})