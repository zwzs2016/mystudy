let vm_videos=new Vue({
    el:"#videos",
    data:{
        order_arr:{},
        type:''
    },
    methods:{
      getcollection(){
          axios.get("/video/videos?type=collection").then(function (res) {
              if(res.data){
                  vm_videos.order_arr=res.data;
                  $("#type").text('我的收藏');
                  vm_videos.type='collection';
              }
          })
      },
      getmywords(){
          axios.get("/video/videos?type=words").then(function (res) {
              if(res.data){
                  vm_videos.type='words';
                  vm_videos.order_arr=res.data;
                  $("#type").text('我的评论');
              }
          })
      },
      deletebyvideoid(id,type){
          let url=type=='words'?'/words/delwords?id='+id:'/order/deletebyid?id='+id;
          if(type=='collection'){
              url='/order/updatebyid?id='+id+'&isCollection=0'
          }
          if(confirm('您要删除该条记录吗?')){
              axios.get(url).then(function (res) {
                  alert('删除成功!');
                  if(type=='pay'){
                      location.reload();
                  }else if(type=='collection'){
                      vm_videos.getcollection();
                  }else {
                      vm_videos.getmywords();
                  }
              })
          }
          }

    },
    created(){
        axios.get("/video/videos?type=pay").then(function (res) {
            if(res.data){
                vm_videos.order_arr=res.data;
                vm_videos.type='pay';
                console.log(vm_videos.type)
            }
        })
    }
})