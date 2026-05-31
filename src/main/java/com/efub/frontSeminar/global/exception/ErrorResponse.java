package com.efub.frontSeminar.global.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    @Schema(description = "HTTP 상태 코드", example = "404")
    private int status;

    @Schema(description = "에러 이름", example = "POST_NOT_FOUND")
    private String error;

    @Schema(description = "에러 메시지", example = "존재하지 않는 게시글입니다.")
    private String message;

    public static ErrorResponse from(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getStatus().value())
                .error(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }
}