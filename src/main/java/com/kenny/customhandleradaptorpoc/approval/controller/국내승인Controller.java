package com.kenny.customhandleradaptorpoc.approval.controller;

import com.kenny.customhandleradaptorpoc.approval.controller.dto.국내승인DTO;
import com.kenny.customhandleradaptorpoc.approval.service.국내승인Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class 국내승인Controller {

    private final 국내승인Service domesticApprovalService;

    @PostMapping
    public 국내승인DTO.승인.Out process국내승인( final 국내승인DTO.승인.In input ) {
        log.debug("# 국내승인Controller process국내승인 : {}", input.toString());
        return domesticApprovalService.process국내승인(input);
    }

    @PostMapping
    public 국내승인DTO.취소.Out process국내취소( final 국내승인DTO.취소.In input ) {
        log.debug("# 국내승인Controller process국내취소 : {}", input.toString());
        return domesticApprovalService.process국내승인취소(input);
    }
}
