import java.lang.instrument.Instrumentation;

/**
 * Created by rtsypuk on 6/1/16.
 */
public class TraceAgent {
    public static void premain(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent Class Tracer is loaded");
        instrumentation.addTransformer(new TraceTransformer());
    }
}