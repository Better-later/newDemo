package com.example.newdemo.dailytest;

import com.example.newdemo.util.ThreadLocalUtil;

import java.util.*;

class User {
    String code;

    public User(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

public class Main {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
            new User("A"),
            new User("C"),
            new User("D"),
            new User("B")
        );
        ThreadLocalUtil.get();

        // 定义优先级映射
        Map<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("A", 1);
        priorityMap.put("C", 2);
        priorityMap.put("D", 3);
        priorityMap.put("B", 4);

        // 排序 userList 根据优先级
        userList.sort(Comparator.comparingInt(user -> priorityMap.get(user.getCode())));

        // 输出最高优先级的 User
        System.out.println("User with highest priority: " + userList.get(0).getCode());

//        // 找到优先级最高的 User 对象
//        User highestPriorityUser = null;
//        int highestPriority = Integer.MAX_VALUE;
//
//        for (User user : userList) {
//            int priority = priorityMap.getOrDefault(user.getCode(), Integer.MAX_VALUE);
//            if (priority < highestPriority) {
//                highestPriority = priority;
//                highestPriorityUser = user;
//            }
//        }
//
//        if (highestPriorityUser != null) {
//            System.out.println("最高优先级的 User 对象: " + highestPriorityUser.getCode());
//        } else {
//            System.out.println("userList 为空或没有匹配的优先级");
//        }
    }
}
