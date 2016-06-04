import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.tsypuk on 5/28/16.
 */
public class AgentTester {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        printObjectSize(list);
        Integer integer = new Integer(127);
        printObjectSize(integer);

        String str = "TEST";
        printObjectSize(str);

        for (Class cl : AgentMemoryCounter.getLoadedClasses(new Object())) {
            System.out.println(cl.getName());
        }
    }

    public static void printObjectSize(Object obj) {
        System.out.println(String.format("Object class is: %s, size=%s", obj.getClass()
                .getSimpleName(), AgentMemoryCounter.getSize(obj)));
    }
}