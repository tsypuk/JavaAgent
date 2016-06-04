package jav.smart;

import java.util.Random;

public class A {
//    private String privateField1 = "My private field";
//    protected String protectedField2 = "My protected field";
//    String packageField1 = "My default field";
//    public String publicField1 = "My public field";
    public void foo()
            throws InterruptedException {
        System.out.println("My program is running...");
        Thread.sleep(new Random().nextInt(5000));
        System.out.println("This is real foo() method.");
    }
    public void bar(String input) {}
}