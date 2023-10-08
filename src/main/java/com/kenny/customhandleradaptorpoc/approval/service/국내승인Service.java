package com.kenny.customhandleradaptorpoc.approval.service;

import com.kenny.customhandleradaptorpoc.approval.service.dto.국내승인DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class 국내승인Service {

    public 국내승인DTO.승인.Out process국내승인( final 국내승인DTO.승인.In input ) {
        log.debug( "# 국내승인 : {}", input.toString() );

        return 국내승인DTO.승인.Out.builder()
                .결과코드("OK")
                .build();
    }

    public 국내승인DTO.취소.Out process국내승인취소( final 국내승인DTO.취소.In input ) {
        log.debug( "# 국내승인 : {}", input.toString() );

        return 국내승인DTO.취소.Out.builder()
                .결과코드("OK")
                .build();
    }
}
