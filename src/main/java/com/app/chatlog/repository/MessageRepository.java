package com.app.chatlog.repository;

import com.app.chatlog.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    public List<Message> findAllByUser(Long user, Pageable pageable);
    public void deleteByUser(Long user);
    public void deleteByUserAndMessage(Long user,Long id);
}
