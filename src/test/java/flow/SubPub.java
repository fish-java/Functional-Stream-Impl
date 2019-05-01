package flow;

import org.junit.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class SubPub {
    @Test
    public void base() throws Exception{
        // 创建一个发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 创建一个订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            // 订阅的时候触发
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                // 把publisher信息存储起来，以后调用
                this.subscription = subscription;
                System.out.println("I am subscribed");
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收到：" + item);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("I am ok....");
            }
        };

        // 建立关系
        //   不是，逻辑上不是应该subscriber订阅publisher吗？
        publisher.subscribe(subscriber);
        // onSubscribe被调用

        publisher.submit("明天有雨");

        publisher.close();

        // 延迟保证
        Thread.currentThread().join(1000);
    }

    public static void main(String[] args) throws Exception{
        // 创建一个发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 创建一个订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            // 订阅的时候触发
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                // 把publisher信息存储起来，以后调用
                this.subscription = subscription;
                System.out.println("I am subscribed");
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收到：" + item);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("I am ok....");
            }
        };

        // 建立关系
        //   不是，逻辑上不是应该subscriber订阅publisher吗？
        publisher.subscribe(subscriber);
        // onSubscribe被调用

        publisher.submit("明天有雨");

        publisher.close();

        // 延迟保证
        Thread.currentThread().join(1000);
    }
}
