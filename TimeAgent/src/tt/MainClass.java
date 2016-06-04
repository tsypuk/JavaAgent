package tt;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;

/**
 * Created by rtsypuk on 6/1/16.
 */
public class MainClass {

    public static void premain(String args, Instrumentation instrumentation) throws Exception {
        System.out.println("Time Machine is loaded..");
        instrumentation.addTransformer(new ClassTransformer(), true); // Указываем системе, что она может использовать наш ClassTransformer для изменения классов
    }
}