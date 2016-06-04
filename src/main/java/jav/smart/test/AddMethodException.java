package jav.smart.test;

import jav.smart.A;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by roman.tsypuk on 5/29/16.
 */
public class AddMethodException {
        public static void main(String[] args) throws Exception {
            A a = getA();
            a.foo();
        }
    private static A getA() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("java.io");
        CtClass ct = classPool.get("jav.smart.A");

        CtMethod fooMethod = ct.getMethod("foo", "()V");
        fooMethod.insertBefore("{throw new IOException(); }");
        return (A) ct.toClass().newInstance();
    }
}
