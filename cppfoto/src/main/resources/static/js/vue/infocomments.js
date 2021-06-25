let vm_infocomments=new Vue({
        el:"#words",
        data:{
            words_arr:[]
        },
        methods:{

        },
        created(){
            axios.get("/words").then(function (response) {
                if (response.data){
                    vm_infocomments.words_arr=response.data;
                }
            })
        }
    })