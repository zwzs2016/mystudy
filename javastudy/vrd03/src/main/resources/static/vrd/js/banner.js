let vm_banner=new Vue({
    el:"#myCarousel",
    data:{
        banner_arr:[],
        user:{}
    },
    methods:{
        deleteById(id) {
            //向deltetebanner?id=xxx发出请求
            if(!confirm('您确定删除此轮播图吗?')){
                return;
            }
            axios.get("/deletebanner?id="+id).then(function (response) {
                location.reload();
            }).catch(function (err) {
                alert(err);
            })
        },
        upload(){
            //得到上传的数据, 修改上传文件的编码类型
            let data=new FormData($("form")[0]);
            //发出异步请求
            axios.post("/uploadbanner",data).then(function (response) {
                location.reload();
            }).catch(function (err) {
                alert(err)
            })
        }
    },
    created(){
        axios.get("/selectbanner").then(function (response) {
            vm_banner.banner_arr=response.data;
        })
    }
})