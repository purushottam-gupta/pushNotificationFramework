package com.shipuru.service;

import com.shipuru.model.PushNotification;
import com.shipuru.repository.PushNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {

    @Autowired
    private PushNotificationRepository pushNotificationRepository;

    @Autowired
    private ExceptionThrower exceptionThrower;

    Boolean flag=true;

    @Override
    public List<PushNotification> sendNotification() {
        if(flag) {
            flag=false;
            List<PushNotification> pushNotifications = new ArrayList<>();
            pushNotifications.add(exceptionThrower.doSomething("RuntimeException", "KpiName", "SUPERADMIN"));
            pushNotifications.add(exceptionThrower.doSomething("ArithmeticException", "Jira", "Puru"));
            pushNotifications.add(exceptionThrower.doSomething("RequestNotFound", "Sonar", "Shivani"));
            pushNotificationRepository.save(pushNotifications);
        }
        return pushNotificationRepository.findAll();
    }
}

