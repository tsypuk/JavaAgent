import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * Created by rtsypuk on 6/1/16.
 */
public class ClassTransformer implements ClassFileTransformer {

    private static int count = 0;

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) {
        System.out.println(String.format("%d. Loading class: %s ",++count, className.replaceAll("/", ".")));
        return classfileBuffer;
    }
}