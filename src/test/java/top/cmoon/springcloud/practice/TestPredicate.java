package top.cmoon.springcloud.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Predicate;

/**
 * Created by cool_moon on 2017/10/22.
 */
public class TestPredicate {

    private List<String> languages;

    @Before
    public void init() {
        languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    }

    @Test
    public void test() {


        Predicate<String> startsWithJ = l -> l.startsWith("J");

        Predicate<String> lengthIs4 = l -> {
            this.this_test();
            boolean result = l.length() == 4;
            return result;
        };

        filter(startsWithJ.and(startsWithJ.and(lengthIs4)));
    }


    public void filter(Predicate<String> condition) {
        for (String name : languages) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


    public void this_test() {
        System.out.println("this test");
    }
}
