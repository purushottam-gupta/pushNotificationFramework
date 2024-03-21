package com.shipuru.controller;

import com.shipuru.model.PushNotification;
import com.shipuru.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/push-notifications")
public class PushNotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @GetMapping
    public ResponseEntity<List<PushNotification>> sendNotification() {
        List<PushNotification> notifications = pushNotificationService.sendNotification();
        return ResponseEntity.ok(notifications);
    }
}

