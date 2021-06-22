let vm_info=new Vue({
        el:"#content",
        data:{
            article_arr:[],
            articleimgurl:'',
            userimgurl:''
        },
        methods:{
           async getArticleImgUrl(id){
                let url='';
                await axios.get("/selectbyarticleid?id="+id).then(function (response) {
                    if(response.data){
                        url=response.data.imgUrl;
                        return url;
                    }
                })
                return data;
            },
            getUserImgUrl(id){
                let url='';
                axios.get("/selectbyuserid?id="+id).then(function (response) {
                    if(response.data){
                        url=response.data.imgUrl;
                    }
                })
                return url;
            }
        },
        created(){
           axios.get("/article/info").then(function (response) {
                if (response.data){
                    vm_info.article_arr=response.data;
                }
           })
        },
        updated() {

        }
})