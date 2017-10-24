package top.cmoon.springcloud.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by cool_moon on 2017/10/22.
 */
public class TestMap {


    @Test
    public void test() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        Stream<Double> tax = costBeforeTax.stream().map((Integer cost) -> cost + .12 * cost);

        Optional<Double> doubleOptional = tax.reduce((sum, cost) -> sum + cost);


        System.out.println(doubleOptional.orElse(0D));
    }


}
