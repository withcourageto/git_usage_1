package top.cmoon.springcloud.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * Created by cool_moon on 2017/10/22.
 */
public class TestJavaSteramApi {


    public List<Integer> randomIntList(int maxNum, int size) {

        Random random = new Random();
        List<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(maxNum));
        }
        return arr;
    }

    private List<Integer> list;

    @Before
    public void init() {
        list = randomIntList(10000, 100000);
    }

    @Test
    public void test() {
        System.out.print("iterator time:");
        testTime(list, arr -> iteratorMaxInteger(arr));

        System.out.print("foreach time:");
        testTime(list, arr -> forEachLoopMaxInteger(arr));

        System.out.print("for time:");
        testTime(list, arr -> forMaxInteger(arr));

        System.out.print("parallelStreamMaxInteger time:");
        testTime(list, arr -> parallelStreamMaxInteger(arr));

        System.out.print("lambdaMaxInteger time:");
        testTime(list, arr -> lambdaMaxInteger(arr));

        System.out.print("streamMaxInteger time:");
        testTime(list, arr -> streamMaxInteger(arr));


    }

    public void testTime(List<Integer> nums, Function<List<Integer>, Integer> function) {

        long start_time = System.currentTimeMillis();
        function.apply(nums);
        long end_time = System.currentTimeMillis();
        System.out.println(end_time - start_time);
    }

    public int streamMaxInteger(List<Integer> integers) {
        Optional<Integer> max = integers.stream().reduce(Integer::max);
        return max.get();
    }

    public int lambdaMaxInteger(List<Integer> integers) {
        return integers.parallelStream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }

    public int parallelStreamMaxInteger(List<Integer> nums) {
        return nums.parallelStream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, Math::max);
    }


    public int forMaxInteger(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, list.get(i));
        }
        return max;
    }

    public int forEachLoopMaxInteger(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer n : list) {
            max = Integer.max(max, n);
        }
        return max;
    }


    public int iteratorMaxInteger(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next());
        }
        return max;
    }

}
