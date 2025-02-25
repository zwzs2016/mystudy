let vm_video=new Vue({
    el:"#video",
    data:{
      category_arr:[],
      images_arr:[],
      video_arr:[],
      pageinfo:{},
      categoryname:''
    },
    methods:{
        videopages(pageNum){
            //video_arr
            let categoryId=location.search.split('=')[1];
            axios.get("/video?categoryId="+(categoryId==undefined?24:categoryId)+"&pageNum="+pageNum).then(function (res) {
                if(res.data){
                    vm_video.video_arr=res.data.list;
                    vm_video.pageinfo=res.data;
                }
            })
        }
    },
    created(){
        axios.get("/category?directory=视听").then(function (res) {
            if(res.data){
                vm_video.category_arr=res.data;
            }
        })
        //video_arr
        let categoryId=location.search.split('=')[1];
        axios.get("/video?categoryId="+(categoryId==undefined?24:categoryId)+"&pageNum=1").then(function (res) {
            if(res.data){
                vm_video.video_arr=res.data.list;
                vm_video.pageinfo=res.data;
            }
        })
        //改变categoryname
        //vm_video.categoryname=location.s
    }
})