package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/26.
 * Java程序员面试宝典：P158 面试例题1
 * 使用强制类型转换把子类向上转型和new一个子类然后赋值给父类引用形成多态
 * 多态对非静态的属于对象的方法是有用的，调用子类的，如果子类覆盖了父类方法，
 * （父类运行时动态绑定根据实际调用子类方法）
 * 静态，和成员域则不在多态范围内
 * Java父类转子类强制转换可以成功的前提是：子类曾经向上转型过！！
 * 父类调用子类因为拓展父类新增的方法，要强制转换为子类，当然子类曾引用赋给过父类才行。
 * 而子类调用父类方法，没什么，因为继承的原因
 * 子类调用和父类同名方法，域很正常，屏蔽了父类方法。
 */
public class Father {
    public int value = 1;

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "," + b);
        Child x = new Child();
        //子类向上转型
        Father y = x;
        Father z = new Child();
        Child m = (Child) z;
        m.noStatic();
        z.noStatic();
        y.noStatic();
        //成员域不在多态的范围
        System.out.println(x.value);
        System.out.println(y.value);
        System.out.println(z.value);
        x.staticMethod();
        z.staticMethod();
        y.staticMethod();
        //父类强制转换为子类会怎样？
        Father w = new Father();
        Child child = (Child) y;
        /*child.noStatic();*/
        w.noStatic();
        System.out.println(child.value);
//        child.noStatic();
        z.noStatic();
        //父类要调用子类方法需要强制转换,成立前提自然是子类引用赋值给父类过
        ((Child) y).childMethod();
        //((Child) w).childMethod();//引发强制转换异常


    }

    private static void staticMethod() {
        System.out.println("静态方法不能被覆盖成非静态的方法,子类覆盖时访问权限大于等于父类");
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    public void noStatic() {
        System.out.println("(父类)非静态的方法，符合多态，调用子类的，如果子类覆盖了父类方法");
    }
}

class Child extends Father {
    public int value = 2;

    protected static void staticMethod() {
        System.out.println("静态方法属于类，不在多态范围");
    }

    public void noStatic() {
        System.out.println("子类的非静态方法");
    }

    public void childMethod() {
        System.out.println("子类有的方法，父类没有，父类不可调用");
    }
}
