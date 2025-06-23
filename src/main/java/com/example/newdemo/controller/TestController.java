package com.example.newdemo.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class TestController {

    @Value("${}")
    private String backUpPath;
    private static Logger log = LoggerFactory.getLogger(TestController.class);


    public static void main(String[] args) {
        new Thread();

        log.info("hell");
        List<String> hello_world = getListname("hello_world");
        List<File> listname = getListname(new File("D:/test/mange.txt"));
        List<? super ArrayList> methodTest = getMethodTest();
        listElementsNotNull(null);

        Function<String, List<String>>  getListnameHandle = TestController::getListname;
        List<String> resdfs = getListnameHandle.apply("aaa");
        CollUtil.split(resdfs,2);

        String path = "D:/test/mange.txt";
        File file1 = new File(path);
        Paths.get(file1.getPath());
        File[] listFiles = file1.listFiles();
        List<String> strList = new ArrayList<>();
        for(int i = 100;i < 300;i ++) {
            if(strList.size() >=100) {
                FileUtil.writeLines(strList,file1,"UTF-8",true);
                strList.clear();
            }
            strList.add(String.valueOf(i));
        }
        if(CollUtil.isNotEmpty(strList)) {
            FileUtil.writeLines(strList,file1,"UTF-8",true);
            strList.clear();
        }

        listElements(1,2,3,4);

//        listElements();
//        for(File f : listFiles) {
//            delFiles(f,"20241124");
//        }
//        List<String> utilList = FileUtil.listFileNames(path);
//        ReUtil.isMatch("^{[0,9]*}$", listFiles[0].getName());
//        List<File> files = delHisFiles(path, "20241124");
//        for (File file : files) {
//            FileUtil.del(file);
//        }


        String date1 = "20241101";
        String date2 = "20241120";
        String date3 = "20241120";
        int res = StrUtil.compareVersion(date1, date2);
        System.out.println("res:" + res);
        int res2 = StrUtil.compare(date1, date2, false);
        System.out.println("res2:" + res2);
        int res3 = StrUtil.compareVersion(date3, date2);
        System.out.println("res3:" + res3);


    }

    public static List<File> delHisFiles(String path, String batchDate) {
        ArrayList<File> res = new ArrayList<>();
        List<File> files = FileUtil.loopFiles(path);
        for (File file : files) {

            if (file.isDirectory() && StrUtil.compare(file.getName(), batchDate, false) < 0) {
                res.add(file);
            }
        }
        return res;
    }


    public static boolean delFiles(File file, String batchDate) {
        int now = Integer.parseInt(batchDate);
        if(file.isDirectory() && (now - 10 ) > Integer.parseInt(file.getName())){
            FileUtil.del(file);
            System.out.println("{}文件被删除:"+file.getName());
        }

        return true;

    }

    public static void listElements(int... args) {
        for(int i : args) {
            System.out.println("now is :" + i);
        }
    }

    public static void listElements(String[] args) {
        System.out.println(args.length);
    }

    public static String listElementsNotNull(@NonNull String name) {
        System.out.println("test method is not null");
        return "name is:" + name;
    }


    public static <T extends Object> List<T> getListname(T name) {
        List<T> res = new ArrayList<T>();
        res.add(name);
        return res;
    }

    public static List<? super ArrayList> getMethodTest() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("ssss");
        objects.add(CollUtil.toList("1", "2"));
        return objects;
    }

    public  static void addNumbers(List<? super Integer> list) {
        list.add(10); // 可以添加 Integer 类型
        list.add(20); // 可以添加 Integer 类型
        list.add(30);
        list.add(40);
        list.add(50);
    }
}
