package interfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathInterfaceTest {
    @Test
    public void triple(){
        // 直接创建一个实现对应接口的类的实例
        MathInterface math = (i) -> {
            return 3 * i;
        };

        int res = math.triple(2);

        assertEquals(6, res);

        assertEquals(2, math.doubl(1));
    }

    private static class Math{
        static int doubl(MathInterface mathInterface, int value){
            return mathInterface.doubl(value);
        };
    }
    @Test
    public void doSomethings(){
        int res = Math.doubl((i -> i * 2), 3);
        assertEquals(6, res);
    }
}