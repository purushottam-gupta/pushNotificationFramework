package com.shipuru.repository;

import com.shipuru.model.PushNotification;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PushNotificationRepository {

    private final List<PushNotification> pushNotifications = new ArrayList<>();

    public void save(List<PushNotification> pushNotification) {
        pushNotifications.addAll(pushNotification);
    }

    public List<PushNotification> findAll() {
        return pushNotifications;
    }
}
