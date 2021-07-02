let vm_detailn=new Vue({
    el:"#detail",
    data:{
        video:''
    },
    created(){
        let id=location.search.split("=")[1];
        axios.get("/video/selectbyid?id="+id).then(function (response) {
            if (response.data){
                vm_detailn.video=response.data;
                $("#title").text(vm_detailn.video.title+'视频');
            }
        })
    }
})