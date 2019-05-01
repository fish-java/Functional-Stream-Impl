import org.junit.Test;

import java.util.function.Consumer;

public class Closure {
    // 闭包以及函数柯里化，其实柯里化类似于装饰器
    @Test
    public void closure(){
        Consumer<String> bobSay = personSay("Bob");
        bobSay.accept("Hello world");
        // Bob: Hello world
    }

    // 返回了一个新的函数，
    //   它引用了name，形成了闭包
    private Consumer<String> personSay(String name){
        Consumer<String> bobSay = s -> System.out.println(name + ": " + s);
        return bobSay;
    }
}
