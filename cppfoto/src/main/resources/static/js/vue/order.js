let vm_order=new Vue({
    el:"#order",
    data:{
        video:{},
        imgurl_pay:''
    },
    created(){
        let id=location.search.split("=")[1];
        axios.get("/video/selectbyid?id="+id).then(function (response) {
            if (response.data){
                vm_order.video=response.data;
            }
        });

        $("#open_window").click(function () {
            $("#payimg").attr('src','/qrcode/createCommonQRCode?url=http://localhost:8081/order?id='+vm_order.video.id);
        })
    }
})