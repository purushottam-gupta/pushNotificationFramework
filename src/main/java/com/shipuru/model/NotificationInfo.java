package com.shipuru.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
public class NotificationInfo {

    private String message;
    private LocalDateTime timestamp;
    private String projectName;
    private boolean isEnabled;
    private String tag;
}