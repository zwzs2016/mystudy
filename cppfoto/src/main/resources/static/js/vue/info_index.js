let vm_info=new Vue({
        el:"#content",
        data:{
            article_arr:[],
            category_arr:[],
            articleimgurl:'',
            userimgurl:'',
            searchUser:''
        },
        methods:{

            search(){
                if(vm_info.searchuser==''){
                    alert('请输入搜索内容!')
                    return;
                }
                location.href='/info.html?searchUser='+vm_info.searchUser;
            }
        },
        created(){
            if (location.search.indexOf("categoryId")!=-1){
                let id=location.search.split("=")[1];
                axios.get("/article/info?categoryId="+id).then(function (response) {
                    if(response.data){
                        vm_info.article_arr=response.data;
                    }
                })
            }else if (location.search.indexOf("searchText")!=-1){
                let searchText=location.search.split("=")[1];
                axios.get("/article/info?searchText="+searchText).then(function (response) {
                    if (response.data){
                        vm_info.article_arr=response.data;
                    }
                })
            }else if(location.search.indexOf("searchUser")!=-1){
                let searchUser=location.search.split("=")[1];
                axios.get("/article/info?searchUser="+searchUser).then(function (response) {
                    if (response.data){
                        vm_info.article_arr=response.data;
                    }
                })
            }
            else {
                axios.get("/article/info").then(function (response) {
                    if (response.data){
                        vm_info.article_arr=response.data;
                    }
                });
            }
           //获取首页分类
            axios.get("/category").then(function (response) {
                if (response.data){
                    vm_info.category_arr=response.data;
                }
            })
        },
        updated() {
            $(".cont_wrap").imagesLoaded().progress(function () {
                // $(".grid").masonry("layout");//让瀑布流框架重新计算元素位置
                //瀑布流初始化代码
                if ($(window).width() < 1260) {
                    $('.cont_wrap').width(1008);
                } else {
                    $('.cont_wrap').width(1260);
                }
                $(".cont_wrap").masonry({
                    singleMode: true,
                    animate: true,
                    resizeable: true,
                    itemSelector: '.grid-item'
                });
                setInterval(function () {
                    $(".cont_wrap").masonry({
                        singleMode: true,
                        animate: true,
                        resizeable: true,
                        itemSelector: '.grid-item'
                    });
                }, 1000);
            });
        },
        watch:{
            article_arr(newdata,olddata){
                if(olddata.length>0){
                    this.article_arr=newdata;
                    $(".cont_wrap").masonry({
                        singleMode: true,
                        animate: true,
                        resizeable: true,
                        itemSelector: '.grid-item'
                    });
                }
            }
        }
})