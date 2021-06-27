let vm_coins=new Vue({
    el:"#myscore",
    data:{
        score_arr:[],
        score_sum:0
    },
    created(){
        axios.get("/integral").then(function (res) {
            if(res.data){
                vm_coins.score_arr=res.data;
            }
        });
        axios.get("/integral/scoresum").then(function (res) {
            if (res.data){
                vm_coins.score_sum=res.data;
            }
        })
    },

})