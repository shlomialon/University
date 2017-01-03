package PartA;

/**
 * Created by Shlomi Alon on 02/01/2017.
 */
public interface Alpha {
     default int methodA(){
        int result = 0;
        System.out.println("Print from Alpha methodA");
        return  result + 4;
    }
}

interface  Betta extends Alpha{
     default int methodA(){
        int result = 0;
        System.out.println("Print from Betta methodA");
        return result + 8;
    }
}


interface  Gamma extends Alpha{
     default int methodA(){
        int result = 0;
        System.out.println("Print from Gamma methodA");
        return result + 16;
    }
}

// solution 1
//class  Delta implements Betta, Gamma{
//
//
//
//    public static void main(String[] args) {
//        Delta obj  = new Delta();
//        obj.methodA();
//    }
//
//    @Override
//    public int methodA() {
//        int result = 0;
//        System.out.println("Print from Delta methodA");
//        return result + 32;
//    }
//}

//// solution 2
//class  Delta implements Betta, Gamma{
//
//    public static void main(String[] args) {
//        Delta obj  = new Delta();
//        obj.methodA();
//    }
//
//    @Override
//    public int methodA() {
//        return Betta.super.methodA();
//    }
//}

// solution 3
//class  Delta implements Betta, Gamma{
//
//    public static void main(String[] args) {
//        Delta obj  = new Delta();
//        obj.methodA();
//    }
//
//    @Override
//    public int methodA() {
//        return Gamma.super.methodA();
//    }
//}

