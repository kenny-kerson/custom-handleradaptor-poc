package com.kenny.customhandleradaptorpoc.approval.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class 해외승인DTO {

    public static class 승인 {

        @Getter
        @Builder
        @ToString
        public static class In {
            private final String 국가코드;
            private final String 승인번호;
            private final String 카드번호;
            private final String 승인금액;
            private final String 통화코드;
        }

        @Getter
        @Builder
        @ToString
        public static class Out {
            private final String 결과코드;
        }
    }

    public static class 취소 {

        @Getter
        @Builder
        @ToString
        public static class In {
            private final String 국가코드;
            private final String 승인번호;
        }

        @Getter
        @Builder
        @ToString
        public static class Out {
            private final String 결과코드;
        }
    }
}
