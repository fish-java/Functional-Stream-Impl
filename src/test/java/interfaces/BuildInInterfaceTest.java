package interfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;

// 几个jdk自带的函数接口
public class BuildInInterfaceTest {
    @Test
    public void predicate(){
        // 传入类型T，返回Boolean，通常用作断言
        Predicate<Integer> passive = (i) -> i > 0;

        Assert.assertTrue(passive.test(3));
    }

    // 消费者，接受一个参数，没有返回值
    @Test
    public void consumer(){
        Consumer<String> print = s -> System.out.println(s);

        print.accept("Hello world!");
    }

    @Test
    public void consumer2(){
        // 左边参数和右边参数一致时，可以简写成下面的格式
        //    直接给出方法的引用
        Consumer<String> println = System.out::println;

        println.accept("Hello world!");
    }
}
