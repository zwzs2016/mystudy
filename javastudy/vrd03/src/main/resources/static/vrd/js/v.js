//自定义模块
Vue.component('myview',{
    props:["names","myfn","isShow"],
    template:
    `
        <div id="vm">
            <ul>
                <li v-for="name in names" v-text="name"  @click="myfn(name)"></li>
            </ul>
            <h1 v-if="isShow">这是h1</h1>
        </div>
    `
})
let vm=new Vue({
    el:"#vm",
    data:{
        names:["刘备","关羽","张飞"],
        isShow:true
    },
    methods:{
        myfn(name){
            alert(name)
        }
    },
    created(){

    }
})