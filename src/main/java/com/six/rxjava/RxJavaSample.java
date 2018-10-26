package com.six.rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hellenxu on 2017-07-04.
 */
public class RxJavaSample {
    private static void change(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.fromIterable(list)
                .filter(i -> i % 2 == 0)
                .subscribe(System.out::println);

        Observable.range(1, 6)
                .filter(i -> i % 2 == 0)
                .subscribe(System.out::println);

        Observable.range(0, 2)
                .doAfterNext(i -> System.out.println("i: " + i))
                .flatMap(index -> Observable.range(0, 3))
                .doOnNext(j -> System.out.println("j: " + j))
                .subscribe();

        String data = "Hello";
        Observable.just(data)
                .subscribe(System.out::println);

        Integer i = 50;
        boolean b = true;
        Observable.just(data, i, b)
                .subscribe(System.out::println);
    }

    public static void main(String[] args){
        change();
    }
}
