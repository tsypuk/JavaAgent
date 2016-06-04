package jav.smart.test;

/**
 * Created by rtsypuk on 6/1/16.
 */
public class CalculateLoadedClasses {
    public static void main(String[] args) {
        FirstClass a = new FirstClass();
        SecondClass b = new SecondClass();
        ThirdClass c = new ThirdClass();
        String s = "This is inside the main method call";
        System.out.println(s);
    }

}
class FirstClass {};
class SecondClass {};
class ThirdClass {};
