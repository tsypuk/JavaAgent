package jav.smart.test;

import jav.smart.A;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by roman.tsypuk on 5/29/16.
 */
public class AddMethodParamethers {
    public static void main(String[] args) throws Exception {
        A a = getA();
        a.foo();
        a.bar("Summer is comming");
    }
    private static A getA() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("java.util");
        CtClass ct = classPool.get("jav.smart.A");
        CtMethod barMethod = ct.getMethod("bar", "(Ljava/lang/String;)V");
        barMethod.insertBefore("{System.out.println($1);}");
        return (A) ct.toClass().newInstance();
    }
}