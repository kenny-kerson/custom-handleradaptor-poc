package com.kenny.customhandleradaptorpoc.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenny.customhandleradaptorpoc.approval.controller.dto.국내승인DTO;
import com.kenny.customhandleradaptorpoc.approval.controller.dto.해외승인DTO;
import com.kenny.customhandleradaptorpoc.approval.controller.국내승인Controller;
import com.kenny.customhandleradaptorpoc.approval.controller.해외승인Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Slf4j
public class 승인HandlerAdapter implements HandlerAdapter, Ordered {

    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(final Object handler) {
        return handler instanceof 국내승인Controller || handler instanceof 해외승인Controller;
    }

    @Override
    public ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        final byte[] body = IOUtils.toByteArray(request.getInputStream());
        final String bodyString = IOUtils.toString(request.getReader());

        final String prefix = new String(body, 0, 3);
        final String amount = new String(body, 3, 5);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        switch ( prefix ) {
            case "100" -> {
                final 국내승인DTO.승인.Out output = ((국내승인Controller) handler).process국내승인(국내승인DTO.승인.In.builder()
                        .승인금액(amount)
                        .build());

                final String outputJson = objectMapper.writeValueAsString(output);
                response.getWriter().write(outputJson);
            }
            case "101" -> {
                final 국내승인DTO.취소.Out output = ((국내승인Controller) handler).process국내승인취소(국내승인DTO.취소.In.builder()
                        .build());

                final String outputJson = objectMapper.writeValueAsString(output);
                response.getWriter().write(outputJson);
            }
            case "200" -> {
                final 해외승인DTO.승인.Out output = ((해외승인Controller) handler).process해외승인(해외승인DTO.승인.In.builder()
                        .승인금액(amount)
                        .build());

                final String outputJson = objectMapper.writeValueAsString(output);
                response.getWriter().write(outputJson);
            }
            case "201" -> {
                final 해외승인DTO.취소.Out output = ((해외승인Controller) handler).process해외승인취소(해외승인DTO.취소.In.builder()
                        .build());

                final String outputJson = objectMapper.writeValueAsString(output);
                response.getWriter().write(outputJson);
            }
        }

        return null;
    }

    @Override
    public long getLastModified(final HttpServletRequest request, final Object handler) {
        return -1;
    }

    @Override
    public int getOrder() {
        return 0;   // 0 is higher priority than, for example, 1 or 10
    }
}
