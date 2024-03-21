package com.shipuru.service;

import com.shipuru.model.NotificationInfo;
import com.shipuru.model.PushNotification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class ExceptionThrower {

    public PushNotification doSomething(String ex, String src, String user) {
        try {
            if (ex.equalsIgnoreCase("RuntimeException")){
                throw new RuntimeException("RuntimeException");
            } else if (ex.equalsIgnoreCase("ArthmeticException")) {
                int r=10/0;
            } else if (ex.equalsIgnoreCase("RequestNotFound")) {
                throw new RuntimeException("request not found");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {

            return new PushNotification(0l,
                    user,
                    src,
                    Arrays.asList(
                            new NotificationInfo(
                                    e.getMessage(),
                                    LocalDateTime.now(),
                                    "KnowHow",
                                    true,
                                    "tag1"
                            ),
                            new NotificationInfo(
                                    e.getMessage(),
                                    LocalDateTime.now(),
                                    "Map",
                                    false,
                                    "tag2"
                            )
                    )
            );


        }
        return null;
    }
}

