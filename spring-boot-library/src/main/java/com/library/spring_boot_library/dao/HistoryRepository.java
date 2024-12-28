package com.library.spring_boot_library.dao;

import com.library.spring_boot_library.model.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    Page<History> findBooksByUserEmail(String userEmail, Pageable pageable);
}
