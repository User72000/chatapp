package com.app.chatlog.controller;

import com.app.chatlog.dto.MessageDTO;
import com.app.chatlog.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chatlogs/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/{user}")
    public Long create(@PathVariable Long user, @RequestBody MessageDTO messageDTO){
      return  messageService.create(user, messageDTO);
    }

    @GetMapping("/{user}")
    public List<MessageDTO> get(@PathVariable Long user, @RequestParam Integer limit, @RequestParam Integer start){
        return messageService.get(user,limit,start);
    }

    @DeleteMapping("/{user}/{msgid}")
    public void get(@PathVariable Long user,@PathVariable(required = false) Long msgid){
        messageService.delete(user,msgid);
    }
}
