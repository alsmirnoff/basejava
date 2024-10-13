package ru.javawebinar.basejava.junitexample;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MathFunc2Test {
    private MathFunc2 math;

    @Before
    public void init() { math = new MathFunc2(); }
    @After
    public void tearDown() { math = null; }

    @Test
    public void calls() {
        assertEquals(0, math.getCalls());

        math.factorial(1);
        assertEquals(1, math.getCalls());

        math.factorial(1);
        assertEquals(2, math.getCalls());
    }

    @Test
    public void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Ignore
    @Test
    public void todo() {
        assertTrue(math.plus(1, 1) == 3);
    }

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(MathFunc2Test.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        List <Failure> failures = result.getFailures();
        for (Failure failure : failures) {
            System.out.println("failed test error msg: " + failure.toString());
        }
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}