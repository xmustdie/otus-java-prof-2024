import test.TestClass;
import test.TestRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Andrei Durkin <a.durkin@goodt.me> at 27.07.2024
 */

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TestRunner.run(TestClass.class);
    }
}
