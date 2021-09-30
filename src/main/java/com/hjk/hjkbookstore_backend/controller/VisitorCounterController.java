package com.hjk.hjkbookstore_backend.controller;

import com.hjk.hjkbookstore_backend.utils.VisitorCounter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


@RestController
public class VisitorCounterController {
    private final VisitorCounter visitorCounter=new VisitorCounter();

    private class IncreaseCounter implements Runnable{
        @Override
        public void run() {
            visitorCounter.increaseCounter();
        }
    }

    @CrossOrigin
    @RequestMapping("/getVisitorCount")
    public Long getVisitorCount() throws ExecutionException, InterruptedException {
        FutureTask<Long> futureTask= new FutureTask<>(visitorCounter::getCounter);
        Thread thread=new Thread(futureTask);
        thread.start();
        thread.join();
        return futureTask.get();
    }

    @CrossOrigin
    @RequestMapping("/increaseVisitorCount")
    public void increaseVisitorCount() throws InterruptedException {
        Thread thread=new Thread(new IncreaseCounter());
        thread.start();
        thread.join();
    }
}
