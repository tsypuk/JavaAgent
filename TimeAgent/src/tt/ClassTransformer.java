package tt;

import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        if(className.startsWith("tt")) return null;
        try {
            ClassPool pool = ClassPool.getDefault();

            CtClass s1 = pool.get("java.lang.System");
            CtMethod m11 = s1.getDeclaredMethod("currentTimeMillis");
            CtClass s2 = pool.get("tt.MySystem");
            CtMethod m21 = s2.getDeclaredMethod("currentTimeMillis");

            CodeConverter cc = new CodeConverter();
            cc.redirectMethodCall(m11, m21);

            CtClass cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer), false);
            if(cl.isFrozen()) return null;
            CtConstructor[] constructors = cl.getConstructors();
            for(CtConstructor constructor : constructors) {
                constructor.instrument(cc);
            }
            CtMethod[] methods = cl.getDeclaredMethods();
            for(CtMethod method : methods) {
                method.instrument(cc);
            }
            classfileBuffer = cl.toBytecode();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
        return classfileBuffer;
    }
}