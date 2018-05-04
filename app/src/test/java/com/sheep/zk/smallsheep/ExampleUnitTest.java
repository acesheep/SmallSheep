package com.sheep.zk.smallsheep;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        System.out.println("haha");

        assertEquals(4, 2 + 2);
        return;
    }

    @Test
    public void testArrayClass() {
        int[] intArray = new int[]{5, 7, 9};
        Array.set(intArray, 0, 9527);
        Class clazz = intArray.getClass();
        if (clazz.isArray()) {
            int length = Array.getLength(intArray);
            for (int i = 0; i < length; i++) {
                Object object = Array.get(intArray, i);
                String className = object.getClass().getName();
                System.out.println("----> object=" + object + ",className=" + className);
            }
        }
    }


}