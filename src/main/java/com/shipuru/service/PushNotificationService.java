package com.shipuru.service;

import com.shipuru.model.PushNotification;

import java.util.List;

public interface PushNotificationService {

    List<PushNotification> sendNotification();
}
