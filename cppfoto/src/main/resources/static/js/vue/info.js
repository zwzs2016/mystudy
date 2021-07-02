var categoryId=0;
let vm_info=new Vue({
    el:"form",
    data:{
        label_arr:[],
        categoryId:0
    },
    methods:{
    },
    created() {
        axios.get("/category?directory=嘚瑟一下").then(function (response) {
            if (response.data){
                vm_info.label_arr=response.data;
            }
        })
    },
    methods:{
    },
    updated(){
        $(".form-con a").click(function () {
            categoryId=$(this).attr('value');
            vm_info.categoryId=categoryId;
            $(this).css({background: '#f00',border: 'solid 1px #f00',color: '#fff'});
            $(this).siblings().css({background: '#fff',border: 'solid 1px #DFDFDF',color: '#000'})
            $("#hfCategory").val(categoryId);
        })
    },
})