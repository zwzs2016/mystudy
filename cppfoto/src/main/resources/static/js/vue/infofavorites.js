let vm_infofavorites=new Vue({
    el:"table",
    data:{
        collection_arr:[]
    },
    methods:{
      delcollection(id){
          if(confirm("您要删除这条收藏吗?")){
              axios.get("/collection/deletebyid").then(function (res) {
                  alert('删除成功!');
                  location.reload();
              })
          }
      }
    },
    created(){
        axios.get("/collection").then(function (res) {
            if (res.data){
                vm_infofavorites.collection_arr=res.data;
            }
        })
    }
})