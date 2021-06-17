let vm_banner=new Vue({
    el:"#myCarousel",
    data:{
        banners:[],
        user:{}
    },
    methods:{
        login(username,pwd){
            user=
            axios.post()
        }
    },
    created(){
        axios.get("/selectbanner").then(function (response) {
            vm_banner.banners=response.data;
        })
    }
})