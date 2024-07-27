package test;

import annotation.After;
import annotation.Before;
import annotation.Test;

/**
 * @author Andrei Durkin <a.durkin@goodt.me> at 27.07.2024
 */

public class TestClass {

    @Before
    public void beforeOne() {
        System.out.println("Before-1 method execution");
    }

    @Before
    public void beforeTwo() {
        System.out.println("Before-2 method execution");
    }

    @After
    public void after() {
        System.out.println("After-1 method execution\n");
    }

    @Test
    public void methodOne() {
        System.out.println("methodOne testing...");
    }

    @Test
    public void methodTwo() {
        System.out.println("methodTwo testing...");
    }

    @Test
    public void methodWithException() {
        System.out.println("methodWithException testing...");
        throw new IllegalArgumentException();
    }

    @Test
    public void methodFour() {
        System.out.println("methodFour testing...");
    }
}
