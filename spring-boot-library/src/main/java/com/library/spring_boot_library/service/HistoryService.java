package com.library.spring_boot_library.service;

import com.library.spring_boot_library.dao.HistoryRepository;
import com.library.spring_boot_library.model.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    public Page<History> getClientHistory(String userEmail, Pageable pageable) {

        return historyRepository.findBooksByUserEmail(userEmail, pageable);
    }
}
