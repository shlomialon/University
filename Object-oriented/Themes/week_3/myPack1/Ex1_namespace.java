package myPack;

public class Ex1_namespace {
    A a1 = new A();
    A b1 = new A();
}

class A {
    int aa(){
        return 8;
    }
}

class A {                   //  duplicate class: myPack.A  // The type A is already defined
    double aa(){
        return 8.0;
    }
}