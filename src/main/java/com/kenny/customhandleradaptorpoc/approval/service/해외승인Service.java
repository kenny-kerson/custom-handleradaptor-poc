package com.kenny.customhandleradaptorpoc.approval.service;

import com.kenny.customhandleradaptorpoc.approval.controller.dto.해외승인DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class 해외승인Service {

    public 해외승인DTO.승인.Out process해외승인(final 해외승인DTO.승인.In input ) {
        log.debug( "# 해외승인Service process해외승인 : {}", input.toString());
        return 해외승인DTO.승인.Out.builder()
                .결과코드("OK")
                .build();
    }

    public 해외승인DTO.취소.Out process해외승인취소(final 해외승인DTO.취소.In input ) {
        log.debug( "# 해외승인Service process해외승인취소 : {}", input.toString());
        return 해외승인DTO.취소.Out.builder()
                .결과코드("OK")
                .build();
    }
}
