package OthersAboutJava;

/**
 * Created by Lunar on 2016/3/27.
 */
class X {
    Y b = new Y();

    X() {
        System.out.print("X");
    }
}

class Y {
    Y() {
        System.out.print("Y");
    }

    int Y() {
        System.out.println("方法可以和类同名，和构造函数唯一区分是构造函数无返回值");
        return 0;
    }

}

class Z extends X {
    Y y = new Y();

    Z() {
        System.out.print("Z");

    }

    public static void main(String[] args) {
        new Z();
    }
}