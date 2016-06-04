package jav.smart.test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.Modifier;
import javassist.NotFoundException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by rtsypuk on 6/2/16.
 */
public class CreateNewClass {
    public static void main(String[] args)
            throws IOException, CannotCompileException, NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass javaClass = classPool.makeClass("com.serve.Java");
//        CtClass javaClass = classPool.makeClass("com.serve.Java", classPool.get("java.util.HashMap"));
//        Write byte code of new created class to FS
        byte[] classBytecode = javaClass.toBytecode();
//        writeByteCodeToFile(classBytecode);
        javaClass.writeFile("/Users/rtsypuk/IdeaProjects/JavaAgent/out/");


        showAllMethods(javaClass);

    }

    private static void showAllMethods(CtClass javaClass)
            throws CannotCompileException {
        Method[] methods = javaClass.toClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }


    private static void writeByteCodeToFile(byte[] bytecode)
            throws IOException {
        File file = new File("/Users/rtsypuk/IdeaProjects/JavaAgent/out/Serve.class");
        FileOutputStream fs = new FileOutputStream(file);
        BufferedOutputStream bs = new BufferedOutputStream(fs);
        bs.write(bytecode);
        bs.close();
    }
}
