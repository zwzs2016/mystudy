let vm_detail=new Vue({
        el:"#detail",
        data:{
            article:{},
            images_arr:{},
            images_user:{},
            user:{},
            words_arr:[],
            photo_show:''
        },
        methods:{
            imgesset(i){
                vm_detail.photo_show=vm_detail.images_arr[i].imgUrl;
            },
            favorite(){
                axios.get("/collection/add?articleId="+vm_detail.article.id).then(function (response) {
                    if(response.data==1){
                        alert('收藏成功!');
                    }else if(response.data==0){
                        alert('已被收藏了!')
                    }else {
                        alert('您还未登录!');
                        location.href='/login.html';
                    }
                })
            },
            heart(){
                //点赞
                axios.get("/article/heart?id="+vm_detail.article.id).then(function (response) {
                        if (response.data==1){
                            alert('点赞成功!');
                        }else {
                            alert('已经点赞了');
                        }
                })
            },
            words(){
                //发布评论
                if($("#comment_cont").val()==''){
                    alert('请输入内容');
                    return;
                }
                let words={
                    id:null,
                    contents:$("#comment_cont").val(),
                    articleId: vm_detail.article.id,
                    createDate:new Date(),
                }
                axios.post("/words/add",words).then(function (response) {
                    if (response.data==1){
                        alert('发布成功!');
                        location.reload();
                    }else if(response.data==0){
                        alert('已经收藏过了!')
                    } else {
                        alert('您还未登录!');
                        location.href='/login.html';
                    }
                })
            }
        },
        created(){
            let id=location.search.split("=")[1];
            if(id){
                axios.get("/article/detail?id="+id).then(function (response) {
                    if (response.data){
                        vm_detail.article=response.data;
                    }
                })
            }
        },
        watch:{
            article(newdata,olddata){
                let i=0
                if(newdata!=null){
                    axios.get("/selectuserbyid?id="+newdata["userId"]).then(function (response) {
                        vm_detail.user=response.data;
                    });
                    axios.get("/selectbyarticleid?id="+newdata["id"]).then(function (response) {
                        vm_detail.images_arr=response.data;
                        vm_detail.photo_show=vm_detail.images_arr[0].imgUrl;
                    });
                    axios.get("/images/selectbyuserid?id="+newdata["userId"]).then(function (response) {
                        vm_detail.images_user=response.data;
                    });
                    axios.get("/words/selectbyarticleid?id="+newdata["id"]).then(function (response) {
                        if(response.data){
                            vm_detail.words_arr=response.data;
                        }
                    })
                }
            }
        }
    })