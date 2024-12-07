package ru.javawebinar.basejava.junitexample;

import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MathFuncTest {

    int a, b, expResult;

    public MathFuncTest(int a, int b, int expResult) {
        this.a = a;
        this.b = b;
        this.expResult = expResult;
    }

    @Rule
    //public TestRule timeout = new Timeout(100);
    public Timeout globalTimeout = Timeout.millis(1000);

    @SuppressWarnings("rawtypes")
    @Parameterized.Parameters
    public static Collection number() {
        return Arrays.asList(new Object[][]{{1,2,3}, {2,9,11}, {3,3,6}});
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAdd() throws InterruptedException {
        System.out.println("add");
        //int a = 2;
        //int b = 3;
        //int expResult = 5;
        int result = MathFunc.add(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype");
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void testDiv() throws InterruptedException {
        System.out.println("div");
        int a = 8;
        int b = 0;
        int expResult = 4;
        int result = MathFunc.div(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype");
    }

}
