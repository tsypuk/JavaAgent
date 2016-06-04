import java.lang.reflect.Field;

/**
 * Created by roman.tsypuk on 5/28/16.
 */
public class ReflectionReader {
    public static void main(String[] args) {
        String obj = "AAA";
//        getObjectInfo(obj);
    }

//    private static void getObjectInfo(Object obj) {
//        if (obj.getClass().getTypeName().contains("java.lang.Class")) { return;}
//        System.out.println(String.format("Object class is: %s", obj.getClass()
//                .getSimpleName()));
//        Field[] fields = obj.getClass().getDeclaredFields();
//        if (fields.length > 0) {
//            System.out.println(String.format("Found fields %d", fields.length));
//            for (Field field : fields) {
//                System.out.println("fieldName: " + field.getName() + " fieldType: " + field.getType());
//                field.setAccessible(true);
//               getObjectInfo(field);
//            }
//        }
//    }
}
