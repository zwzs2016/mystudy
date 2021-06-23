let vm_info=new Vue({
        el:"#content",
        data:{
            article_arr:[],
            category_arr:[],
            articleimgurl:'',
            userimgurl:'',
        },
        methods:{
            listbycid(id){
                axios.get("/article/info?category="+id).then(function (response) {
                    if(response.data){
                        vm_info.article_arr=response.data;
                    }
                })
            }
        },
        created(){
           axios.get("/article/info").then(function (response) {
                if (response.data){
                    vm_info.article_arr=response.data;
                }
           });

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
        }
})