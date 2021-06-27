let vm_infocomments=new Vue({
        el:"#words",
        data:{
            words_arr:[]
        },
        methods:{
            delwords(id){
                if(confirm("您要删除该条评论吗？")){
                    axios.get("/words/delwords?id="+id).then(function (res) {
                        alert('删除成功!');
                        location.reload();
                    })
                }
            }
        },
        created(){
            axios.get("/words").then(function (response) {
                if (response.data){
                    vm_infocomments.words_arr=response.data;
                }
            })
        }
    })