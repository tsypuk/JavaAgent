package jav.smart.test;

import jav.smart.A;
import javassist.*;
import javassist.bytecode.analysis.Util;
import javassist.tools.reflect.Reflection;

import java.lang.reflect.Field;

/**
 * Created by roman.tsypuk on 5/28/16.
 */
public class AddMethodBody {
    public static void main(String[] args)
            throws Exception {
//        A realA = new A();
//        realA.foo();
//        showAllFields(realA);

//        A a = getA();
//        a.foo();
//        showAllFields(a);

        A a = injectMethodAndGetA();
        a.foo();
        showAllFields(a);
    }

    private static A getA()
            throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("java.util");
        CtClass ct = classPool.get("jav.smart.A");
        ct.addField(CtField.make("public java.lang.String age; ", ct));
        ct.addField(CtField.make("private java.lang.String test; ", ct));
        ct.addField(CtField.make("public java.lang.String serve; ", ct));
        CtMethod fooMethod = ct.getMethod("foo", "()V");
        fooMethod.setBody("{System.out.println(\"Sorry you are wrong !!! this is real foo() method\");}");
        return (A) ct.toClass().newInstance();
    }

    private static A injectMethodAndGetA()
            throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("java.util");
        CtClass ct = classPool.get("jav.smart.A");
        ct.addField(CtField.make("public java.lang.String age; ", ct));
        ct.addField(CtField.make("private java.lang.String test; ", ct));
        ct.addField(CtField.make("public java.lang.String serve; ", ct));
        CtMethod fooMethod = ct.getMethod("foo", "()V");
        CtMethod _foo = CtNewMethod.copy(fooMethod, "_foo", ct, null);
        ct.addMethod(_foo);
        fooMethod.setBody("{long timeInvocation = System.currentTimeMillis(); _foo(); timeInvocation = System.currentTimeMillis() - timeInvocation; System.out.println(timeInvocation + \" msec \");}");

        return (A) ct.toClass().newInstance();
    }

    private static void showAllFields(Object a)
            throws IllegalAccessException {
        Field[] fields = a.getClass().getFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                System.out.println(String.format("Field name: %s, type: %s, value %s %s",field.getName(), field.getType(), field.get(a), Modifier.toString(field.getModifiers())));
            }
        } else {
            System.out.println("No fields found for Class: " + a.getClass().getCanonicalName());
        }
    }
}
