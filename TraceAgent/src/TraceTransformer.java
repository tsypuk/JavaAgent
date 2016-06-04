import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * Created by rtsypuk on 6/1/16.
 */
public class TraceTransformer implements ClassFileTransformer {

    private static StringBuilder space = new StringBuilder(" |___");

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) {
        try {
            if (!className.startsWith("jav/smart")) {
                return classfileBuffer;
            }
            ClassPool cp = ClassPool.getDefault();
            CtClass ct = cp.makeClass(new ByteArrayInputStream(classfileBuffer));
            CtMethod[] methods = ct.getDeclaredMethods();
            for (CtMethod method : methods) {
                space.insert(0, "   ");
                String methodBody = "{System.out.println(\""+ space.toString() + className + "." + method.getName() +" \");}";
                method.insertBefore(methodBody);
            }
            return ct.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classfileBuffer;
    }
}