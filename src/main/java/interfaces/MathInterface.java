package interfaces;

@FunctionalInterface
public interface MathInterface {
    int triple(int i);

    // 默认实现，实现接口的类可以不实现这个方法
    default int doubl(int i){
        return i * 2;
    }
}
