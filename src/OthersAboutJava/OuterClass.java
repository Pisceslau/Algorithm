package OthersAboutJava;

/**
 * Created by Lunar on 2016/4/3.
 * Java知识点：内部类基础
 * <p>
 * 参考：http://www.cnblogs.com/chenssy/p/3388487.html
 * 当我们在创建一个内部类的时候，它无形中就与外围类有了一种联系，依赖于这种联系，
 * 它可以无限制地访问外围类的元素。
 * 我们可以看到内部了InnerClass
 * 可以对外围类OuterClass的属性进行无缝的访问，
 * 尽管它是private修饰的。这是因为当我们在创建
 * 某个外围类的内部类对象时，
 * 此时内部类对象必定会捕获一个指向那个外围类对象的引用，只要我们在访问外围类的成员时，
 * 就会用这个引用来选择外围类的成员
 * 同时如果我们需要生成对外部类对象的引用，
 * 可以使用OuterClassName.this，
 * 这样就能够产生一个正确引用外部类的引用了。当然这点实在编译期就知晓了，
 * 没有任何运行时的成本。
 * <p>
 * 内部类是个编译时的概念，一旦编译成功后，它就与外围类属于两个完全不同的类
 * （当然他们之间还是有联系的）。对于一个名为OuterClass的外围类
 * 和一个名为InnerClass的内部类，在编译成功后，
 * 会出现这样两个class文件：OuterClass.class和OuterClass$InnerClass.class。
 * <p>
 * 在Java中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类。
 * <p>
 * 第一：成员内部类中不能存在任何static的变量和方法；
 * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
 */
public class OuterClass {
    private String name;
    private int age;

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        //OuterClass.InnerClass innerClass1 = outerClass.getInnerClass();
        innerClass.display();
        innerClass.getOuterClass().display();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //外部类的display方法
    public void display() {
        System.out.println("OuterClass");
    }

    /*推荐使用getxxx()来获取成员内部类，
    尤其是该内部类的构造函数无参数时 */
    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public class InnerClass {
        public InnerClass() {
            name = "Mark";//内部类访问外部类
            age = 22;
        }

        public void display() {
            System.out.println("name:" + getName() + ";" + "age:" + getAge());
        }

        //内部类取得外部类引用的方法
        public OuterClass getOuterClass() {
            return OuterClass.this;
        }
    }
}
