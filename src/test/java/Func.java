import org.junit.Test;

import java.util.function.Function;

public class Func {
    // Java中，函数是二等公民
    //   必须把它写成类的形式
    @Test
    public void function(){
        // 定义一个函数对象
        //    两个泛型，前者是参数，后者是返回值
        Function<Integer, Integer> triple = (a) -> {
            return a * 3;
        };
        // 执行它
        Integer res = triple.apply(10);
        System.out.println(res);
    }

    // 匿名函数的基本使用
    @Test
    public void anonymous(){
        new Thread(() -> {
            System.out.println("Hello lambda");
        }).start();
    }

    // 把函数对象当做参数使用
    @Test
    public void args(){
        String[] arguments = {"a", "b", "c"};
        doSomething((args) -> {
            return args.length;
        }, arguments);
    }
    private Integer doSomething(Function<String[], Integer> function,String[] args){
        return function.apply(args);
    }
}
