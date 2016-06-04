package jav.smart.test;

/**
 * Created by rtsypuk on 6/2/16.
 */
public class TraceCall {
    public static void main(String[] args) {
//        System.out.println("hello");
        TraceCall traceCall = new TraceCall();
        traceCall.call1();
    }

    private void call1() {
        call2();
    }

    private void call2() {
        call3();
    }

    private void call3() {
        call4();
    }

    private void call4() {
        call5();
    }

    private void call5() {
        call6();
        recursiveCall(10);
        call7();
    }

    private void call6() {

    }

    private void call7() {

    }

    private int recursiveCall(int i) {
        if (i == 0) {
            return 0;
        }
        return recursiveCall(i - 1);
    }

}