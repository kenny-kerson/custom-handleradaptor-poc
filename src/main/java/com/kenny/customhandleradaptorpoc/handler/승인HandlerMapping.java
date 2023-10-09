package com.kenny.customhandleradaptorpoc.handler;

import com.kenny.customhandleradaptorpoc.approval.controller.국내승인Controller;
import com.kenny.customhandleradaptorpoc.approval.controller.해외승인Controller;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class 승인HandlerMapping implements HandlerMapping, Ordered {

    private final ApplicationContext applicationContext;
    private final String APPROVAL_API_URI_PATH = "/approval";

    @Override
    public HandlerExecutionChain getHandler(final HttpServletRequest request) throws IOException {
        log.warn("# 승인HandlerMapping getHandler()");

        final byte[] body = IOUtils.toByteArray(request.getInputStream());
        final String bodyString = IOUtils.toString(request.getReader());

        final String prefix = new String(body, 0, 3);

        if ( APPROVAL_API_URI_PATH.equals(request.getRequestURI()) && ( "100".equals(prefix) || "101".equals(prefix) ) ) {
            return new HandlerExecutionChain(applicationContext.getBean( 국내승인Controller.BEAN_NAME ));

        } else if ( APPROVAL_API_URI_PATH.equals(request.getRequestURI()) && ( "200".equals(prefix) || "201".equals(prefix) ) ) {
            return new HandlerExecutionChain(applicationContext.getBean( 해외승인Controller.BEAN_NAME ));
        }

        return null;
    }

    @Override
    public int getOrder() {
        return 0;   // 0 is higher priority than, for example, 1 or 10
    }
}
