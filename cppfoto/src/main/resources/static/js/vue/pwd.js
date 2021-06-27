vm_pwd=new Vue({
    el:"form",
    data:{
        oldpwd:'',
        newpwd:'',
        newpwd1:'',
        isoldpwd:false,//原密码
        ispwd:false,//密码格式
        ispwdcheck:false//两次密码
    },
    methods:{
        send(){
            if(this.ispwdcheck==true && this.isoldpwd==true){
                this.ispwdcheck=true;
                let data=new FormData($("form")[0]);
                axios.post("/usersafe",data).then(function (res) {
                    if(res.data==1){
                        alert('修改成功!');
                        self.parent.location.reload();
                    }
                })
            }else {
                alert('您未正确的输入!');
            }

        },
        check(){
            let that=this;
            if(that.oldpwd==''){
                alert('密码不能为空!')
                return;
            }
            axios.post("/check",{password:that.oldpwd}).then(function (res) {
                if(res.data==1){
                    that.isoldpwd=true;
                }else {
                    that.isoldpwd=false;
                }
            })
        },
        checkpwd(){
            console.log(vm_pwd.newpwd1)
            if(vm_pwd.newpwd==vm_pwd.newpwd1){
                vm_pwd.ispwdcheck=true;
            }else {
                vm_pwd.ispwdcheck=false;
            }
        }
    }
})