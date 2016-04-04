package OthersAboutJava;

/**
 * Created by Lunar on 2016/4/4.
 * 深入理解Java虚拟机：静态分派,动态分派
 * 重载：通过参数的静态类型而不是实际类型作为判定依据
 * 静态类型是编译期可知的
 */
public class StaticDispatch {
    static abstract class Human {
        protected abstract void sayHelloDy();
    }

    static class Man extends Human {
        @Override
        protected void sayHelloDy() {
            System.out.println("Hello man");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHelloDy() {
            System.out.println("Hello woman");
        }
    }

    public void sayHello(Human guy) {
        System.out.println("Hello,guy");

    }

    public void sayHello(Man man) {
        System.out.println("Hello,man");

    }

    public void sayHello(Woman woman) {
        System.out.println("Hello,woman");

    }

    public void sayHello(FatherDy fatherDy) {
        System.out.println("Hello Father");

    }

    public static void sayHello(SonDy sonDy) {
        System.out.println("Hello son");

    }

    public static void main(String[] args) {
        StaticDispatch sr = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();
        sr.sayHello(man);
        sr.sayHello(woman);

        man.sayHelloDy();
        woman.sayHelloDy();
        man = new Woman();
        man.sayHelloDy();

        FatherDy fatherDy = new SonDy();//猜想为输出Hello Father
        sr.sayHello(fatherDy);
    }
}
