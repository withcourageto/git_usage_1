package top.cmoon.springcloud.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cool_moon on 2017/10/22.
 */
public class TestFilterList {


    @Test
    public void test() {

        List<String> stringList = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


        List<String> filtered = stringList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());

    }


}
