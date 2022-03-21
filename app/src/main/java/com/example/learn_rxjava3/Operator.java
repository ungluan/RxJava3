package com.example.learn_rxjava3;

import android.util.Log;


import com.example.learn_rxjava3.data.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class Operator {
    private static final String TAG = "MainActivity";
    private static int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] arrays2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};
    private static List<User> users = Arrays.asList(
            new User(1, "demo1", 15),
            new User(1, "demo1", 15),
            new User(2, "demo2", 18),
            new User(3, "demo3", 20),
            new User(4, "demo4", 21),
            new User(5, "demo5", 23),
            new User(6, "demo6", 22)
    );

    public static void justOperator() {
        Observable<int[]> observable = Observable.just(arrays);
        Observer<int[]> observer = new Observer<int[]>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(int @NonNull [] ints) {
                Log.d(TAG, "onNext " + Arrays.toString(ints));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
    }

    public static void justOperator1() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4);
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext " + integer);
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
    }

    public static void fromOperator() {
        Observable<int[]> observable = Observable.fromArray(arrays, arrays2);
        Observer<int[]> observer = new Observer<int[]>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(int @NonNull [] ints) {
                Log.d(TAG, "onNext " + Arrays.toString(ints));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
    }

    public static void fromOperator1() {
        Observable<Integer> observable = Observable.fromArray(1, 2, 3, 4, 5);
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext " + integer);
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
    }

    public static void rangeOperator() {
        Observable.range(1, 10).subscribe(
                value -> Log.d(TAG, "onNext " + value),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void repeatOperator() {
        Observable.range(1, 10).repeat(2).subscribe(
                value -> Log.d(TAG, "onNext " + value),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void intervalOperator() {
        Observable.interval(5000, (long) 1000, TimeUnit.MILLISECONDS).takeWhile(
                value -> value < 10).subscribe(
                value -> Log.d(TAG, "onNext " + value),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void timerOperator() {
        Observable.timer(5, TimeUnit.SECONDS).subscribe(
                value -> Log.d(TAG, "onNext " + value),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void createOperator() {
        Observable.create(emitter -> {
            try {
                for (int i : arrays) {
                    emitter.onNext(i);
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }).subscribe(
                value -> Log.d(TAG, "onNext " + value),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void filterOperator() {
        Observable.fromIterable(users).filter(
                user -> user.getAge() >= 18
        ).subscribe(
                value -> Log.d(TAG, "onNext " + value.toString()),
                error -> Log.d(TAG, "onError"),
                () -> Log.d(TAG, "onCompleted")
        );
    }

    public static void lastOperator() {
        Observable.fromIterable(users).last(new User(1, "demo1", 15)).subscribe(
                value -> Log.d(TAG, "onNext " + value.toString()),
                error -> Log.d(TAG, "onError")
        );
    }

    public static void lastOrErrorOperator() {
        Observable.fromIterable(users).lastOrError().subscribe(
                value -> Log.d(TAG, "onNext " + value.toString()),
                error -> Log.d(TAG, "onError")
        );
    }

    public static void distinctOperator(){

    }
}
