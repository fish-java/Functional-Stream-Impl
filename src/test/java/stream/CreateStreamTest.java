package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamTest {
    @Test
    public void fromList(){
        List<Character> characters = new ArrayList<>();

        for (int i = 60; i < 100; i++) {
            characters.add((char) i);
        }
        characters.stream().forEach(c -> System.out.println(c));
    }

    @Test
    public void fromArray(){
        int[] nums = {1, 2, 3};
        Arrays.stream(nums).sum();
    }

    @Test
    public void fromRandom(){
        new Random().ints().limit(5).forEach(i -> System.out.println(i));

        IntStream.rangeClosed(1, 20).forEach(i -> System.out.println(i));
    }

    @Test
    public void fromCustom(){
        Stream.generate(() -> {
            // 每次都调用这个匿名函数来获得新的值
            System.out.println("call me once");
           return new Random().nextInt();
        }).limit(10).forEach(i -> System.out.println(i));
    }
}
