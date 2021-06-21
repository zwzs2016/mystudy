let vm_product = new Vue({
    el:"#vm_product",
    data:{
        product_arr:[{url:''}],
        view_arr:[],
        like_arr:[]
    },
    created(){
        //发出获取所有作品的请求
        let str=location.search;
        if(str.indexOf("wd")!=-1){
            let wd=str.split("=")[1];
            //发出搜索商品的请求
            axios.get("/findbywd?wd="+wd).then(function (response) {
                vm_product.product_arr=response.data;
            })
        } else if(str.indexOf("cid")!=-1){
            let cid=str.split("=")[1];
            axios.get("/findbycid?id="+cid).then(function (response) {
                vm_product.product_arr=response.data;
            })
        }else {
            axios.get("/selectproduct").then(function (response) {
                vm_product.product_arr=response.data;
            }).catch(function (err) {
                alert(err);
            });
        }

        axios.get("/viewlist").then(function (response) {
            if(response.data){
                vm_product.view_arr=response.data;
            }
        });
        axios.get("/likelist").then(function (response) {
            if (response.data){
                if(response.data){
                    vm_product.like_arr=response.data;
                }
            }
        })
    },//请求数据->把数据赋值给数据->初始化瀑布流
    updated(){
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