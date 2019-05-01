package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class StreamTest {
    private int[] nums;
    @Before
    public void resetNums(){
        nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i;
        }
    }

    @Test
    public void intStream(){
        int sum = IntStream.of(nums)
                .map(i -> i % 2 == 0 ? i : 0)
                .sum();
        System.out.println(sum);
    }

    @Test
    public void filter(){
        int[] singleNumbers = IntStream.of(nums)
                .filter(i -> i % 2 == 1)
                .toArray();
        System.out.println(singleNumbers.length);
    }

    @Test
    public void lazy(){
        int[] nums = {1, 2};

        IntStream.of(nums)
                .filter(i -> {
                    System.out.println("我被调用了");
                    return true;
                })
                .toArray();

        // Stream 是惰性求值，
        //   在调用toArray之类的终止操作前不会真的执行代码
        // 返回流的方法都是中间操作
        IntStream.of(nums)
                .filter(i -> {
                    System.out.println("我没有被调用了");
                    return true;
                });
    }
}
