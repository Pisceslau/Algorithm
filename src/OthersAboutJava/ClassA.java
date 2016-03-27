package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/27.
 * 非静态方法看后，静态方法看后
 */
class ClassA {
    public void printValue() {
        System.out.print("classA");

    }

    public static void printStatic() {
        System.out.println("StaticByA");
    }
}

class ClassB extends ClassA {

    public void printValue() {
        System.out.print("classB");

    }

    public static void printStatic() {
        System.out.println("StaticByB");
    }

}

class Test3 {
    public static void main(String[] args) {
        ClassB objectB = new ClassB();
        objectB.printValue();
        objectB.printStatic();
        ClassA as = (ClassA) objectB;
        as.printStatic();
        as.printValue();
        as = new ClassA();
        as.printValue();
    }

}
