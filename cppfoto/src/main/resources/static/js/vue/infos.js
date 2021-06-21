let vm_infos=new Vue({
        el:"#myarticle",
        data:{
            article_arr:[],
            isarticle:true
        },
        methods:{
            delArticle(id){
                if(confirm('您确定要删除吗?')){
                    axios.get("/article/deletebyid?id="+id).then(function (response) {
                        alert('删除成功!');
                        location.reload();
                    })
                }
            }
        },
        created(){
            //请求数据
            axios.get("/article/infos").then(function (response) {
                if (response.data){
                    vm_infos.article_arr=response.data;
                    vm_infos.isarticle=false;
                }else {
                    alert('您还未登录!');
                    location.href='/login.html';
                }
            })
        }
    })