package com.example.newdemo.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class ThreadUtil {


    public static void main(String[] args) {
        List<Integer> list = CollUtil.toList(1, 2, 3, 4, 5);
        computeListByNtheads(list, 2, split -> {
            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            for (int i = 0; i < split.size(); i++) {
                split.set(i, split.get(i) + 1);
            }
            threadLocal.set(CollUtil.size(split));
//            当前线程是：pool-1-thread-1
//            当前线程是：pool-1-thread-2
//            当前线程是：pool-1-thread-1
            System.out.println("当前线程是：" + Thread.currentThread().getName()+"  size:"+threadLocal.get());
            return null;
        });

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    /**
     * 线程池执行任务
     * @param list 待处理集合
     * @param n 线程数
     * @param function 处理方法
     * @param <T> 数据集合类型
     * @param <R> 返回集合类型
     * @return 处理后的集合
     */
    public static <T, R> List<R> computeListByNtheads(List<T> list, int n, Function<List<T>, List<R>> function) {

        if (n < 0) {
            n = 1;
        }
        if (CollUtil.isEmpty(list)) {
            return null;
        }
        List<List<T>> partitions = ListUtil.split(list, n);
        System.out.println("分割后的子列表: " + partitions);
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        List<Future<List<R>>> futures = new ArrayList<Future<List<R>>>();
        // 提交任务到线程池
        for (List<T> partition : partitions) {
            Future<List<R>> future = executorService.submit(() -> function.apply(partition));
            futures.add(future);
        }

        List<R> result = new ArrayList<>();
        for (Future<List<R>> future : futures) {
            try {
                List<R> resultList = future.get();
                CollUtil.addAll(result, resultList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return result;
    }

}
