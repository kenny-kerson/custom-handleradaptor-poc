package com.kenny.customhandleradaptorpoc.approval.controller;

import com.kenny.customhandleradaptorpoc.approval.controller.dto.해외승인DTO;
import com.kenny.customhandleradaptorpoc.approval.service.해외승인Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class 해외승인Controller {

    private final 해외승인Service overseaApprovalServce;

    @PostMapping("/approval/oversea")
    public 해외승인DTO.승인.Out process해외승인( @RequestBody final 해외승인DTO.승인.In input ) {
        log.debug( "# 해외승인Service process해외승인 : {}", input.toString());
        return 해외승인DTO.승인.Out.builder()
                .결과코드("OK")
                .build();
    }
}
