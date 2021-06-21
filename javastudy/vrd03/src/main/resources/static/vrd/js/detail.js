let vm_detail=new Vue({
        el:"#vm_detail",
        data:{
            product:{},
            isLogin:false
        },
        methods:{
            likeById(id){
                axios.get("/likebyid?id="+id).then(function (response) {
                    //如果点赞成功,likeCount++
                    if(response.data==1){
                        vm_detail.product.likeCount++;
                    }else {
                        alert('不能重复点赞!')
                    }
                    
                })
            }
        },
        created(){
            //检查
            axios.get("/checklogin").then(function (response) {
                vm_detail.isLogin=response.data;
            });

            let id=location.href.split("=")[1];
            axios.get("/selectbyid?id="+id).then(function (response) {
                vm_detail.product=response.data;
                vm_detail.product.created=moment(vm_detail.product.created).format("YYYY年MM月DD日 HH:mm:ss");
            })
        }
    })