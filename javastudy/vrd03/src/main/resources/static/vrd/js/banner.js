let vm_banner=new Vue({
    el:"#myCarousel",
    data:{
        banners:[],
        user:{}
    },
    methods:{

    },
    created(){
        axios.get("/selectbanner").then(function (response) {
            vm_banner.banners=response.data;
        })
    }
})