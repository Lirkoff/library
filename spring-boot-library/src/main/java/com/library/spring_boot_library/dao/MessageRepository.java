package com.library.spring_boot_library.dao;

import com.library.spring_boot_library.model.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByUserEmail(String userEmail, Pageable pageable);

    Page<Message> findByClosed(boolean closed, Pageable pageable);
}
