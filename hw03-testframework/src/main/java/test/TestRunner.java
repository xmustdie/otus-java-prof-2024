package test;

import annotation.After;
import annotation.Before;
import annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Andrei Durkin <a.durkin@goodt.me> at 27.07.2024
 */

public class TestRunner {
    public static void run(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Set<Method> beforeMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Before.class))
                .collect(Collectors.toSet());
        final Set<Method> afterMethod = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(After.class))
                .collect(Collectors.toSet());
        final Set<Method> testMethod = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Test.class))
                .collect(Collectors.toSet());

        final Constructor<?> constructor = clazz.getDeclaredConstructor();
        int successCount = 0;
        for (Method method : testMethod) {
            Object testObject = constructor.newInstance();
            if (invokeMethods(testObject, beforeMethods) == 1) {
                successCount += invokeMethods(testObject, Set.of(method));
            }
            invokeMethods(testObject, afterMethod);
        }

        System.out.printf("\nTotal test running: %d | Success: %d | Failure: %d%n", testMethod.size(), successCount, testMethod.size() - successCount);
    }

    private static int invokeMethods(Object object, Set<Method> methodSet) {
        for (Method method : methodSet) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                return 0;
            }
        }
        return 1;
    }
}
