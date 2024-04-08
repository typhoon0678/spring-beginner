package com.typhoon0678.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(30);
        return new int[]{11, 22, 33, 44, 55};
    }
}
