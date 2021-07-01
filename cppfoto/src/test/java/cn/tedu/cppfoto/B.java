package cn.tedu.cppfoto;

public class B extends A{
    @Override
    public void a() {
        System.out.println("被重写的A中a方法");
    }

    public void b(){
        super.a();
    }

    public static void main(String[] args) {
        new B().a();
        new B().b();
    }
}
