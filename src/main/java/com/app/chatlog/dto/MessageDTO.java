package com.app.chatlog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private String message;
    private Long timestamp;
    private Boolean isSent;
}
