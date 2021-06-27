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
        $(".list-one .form-con a").click(function () {
            vm_info.categoryId=$(this).attr('value');
            categoryId=vm_info.categoryId;
            $(this).css({background: '#f00',border: 'solid 1px #f00',color: '#fff'});
            $("#hfCategory").val(vm_info.categoryId);
        })
    },
})