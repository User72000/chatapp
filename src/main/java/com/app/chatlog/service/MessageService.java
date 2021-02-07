package com.app.chatlog.service;

import com.app.chatlog.dto.MessageDTO;
import com.app.chatlog.entity.Message;
import com.app.chatlog.repository.MessageRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Long create(Long user, MessageDTO messageDTO) {
        Message message=new Message();
        message.setMessage(messageDTO.getMessage());
        message.setIsSent(message.getIsSent());
        message.setTimestamp(message.getTimestamp());
        message.setUser(user);
       return messageRepository.save(message).getId();
    }

    public List<MessageDTO> get(Long user, Integer limit, Integer start) {
        Pageable pageable= PageRequest.of(start,limit, Sort.by("timestamp").descending());
        List<Message> messages=messageRepository.findAllByUser(user,pageable);
        List<MessageDTO> messageDTOS=new ArrayList<>();
        messages.forEach(message -> {
            MessageDTO messageDTO=new MessageDTO();
            messageDTO.setMessage(message.getMessage());
            messageDTO.setTimestamp(message.getTimestamp());
        });
        return messageDTOS;
    }

    public void delete(Long user,Long msgid) {
        if(Objects.nonNull(msgid)) return;
        messageRepository.findById(msgid).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid message id"));
        messageRepository.deleteByUserAndMessage(user,msgid);
    }
}
