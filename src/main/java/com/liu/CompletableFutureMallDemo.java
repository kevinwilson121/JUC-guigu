package com.liu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureMallDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setStudentName("LXL");
        student.setMajor("软件工程");

        //链式编程
        student.setId(2).setStudentName("123").setMajor("1111111");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

//        System.out.println(future.get());

        System.out.println(future.join());

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Student{
    private Integer id;
    private String studentName;
    private String major;
}
