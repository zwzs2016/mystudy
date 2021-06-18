let vm_product = new Vue({
    el:"#vm_product",
    data:{
        product_arr:[{url:''}]
    },
    created(){
        //发出获取所有作品的请求
        axios.get("/selectproduct").then(function (response) {
            vm_product.product_arr=response.data;
            //初始化
            $(".grid").imagesLoaded().progress(function () {
                // $(".grid").masonry("layout");//让瀑布流框架重新计算元素位置
                //瀑布流初始化代码
                $(".grid").masonry({
                    itemSelector:".grid-item",//告诉瀑布流框架 如何找到瀑布流里面的元素
                    columnWidth:210  //设置瀑布流元素每一列所占宽度(元素宽度200+间距10)
                });
            });
            $(".grid-item").hover(function () {
                //得到鼠标
                $(this).children("div").stop().fadeIn(500);
            },function () {
                $(this).children("div").stop().fadeOut(500);
            })
        }).catch(function (err) {
            alert(err);
        })
    },//请求数据->把数据赋值给数据->初始化瀑布流
    update(){
        //此方法vue变量发生发生改变
        $(".grid").imagesLoaded().progress(function () {
            // $(".grid").masonry("layout");//让瀑布流框架重新计算元素位置
            //瀑布流初始化代码
            $(".grid").masonry({
                itemSelector:".grid-item",//告诉瀑布流框架 如何找到瀑布流里面的元素
                columnWidth:210  //设置瀑布流元素每一列所占宽度(元素宽度200+间距10)
            });
        });
        $(".grid-item").hover(function () {
            //得到鼠标
            $(this).children("div").stop().fadeIn(500);
        },function () {
            $(this).children("div").stop().fadeOut(500);
        })
    }
})