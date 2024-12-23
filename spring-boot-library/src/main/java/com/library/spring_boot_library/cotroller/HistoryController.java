package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.entity.History;
import com.library.spring_boot_library.service.HistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/histories")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    @GetMapping("/search/")
    public Page<History> clientHistory(@RequestParam String userEmail, Pageable pageable) {

        return historyService.getClientHistory(userEmail, pageable);
    }
}
