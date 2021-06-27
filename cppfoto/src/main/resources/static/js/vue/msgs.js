let vm_msgs=new Vue({
    el:"#msgs",
    data:{
        msgs_arr:[]
    },
    methods:{
        delmsgsById(id){
            if(confirm('您要删除该条消息吗?')){
                axios.get("/message/deletebyid?id="+id).then(function (res) {
                    alert('删除成功!');
                    location.reload();
                })
            }
        }
    },
    created(){
        axios.get("/message").then(function (res) {
            if(res.data){
                vm_msgs.msgs_arr=res.data;
            }
        })
    }
})