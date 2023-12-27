package com.example.demo3.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @NotBlank
    private String uid;
    @NotBlank
    private String operationUid;
    @NotBlank
    private String operationTime;
    @NotBlank
    private String  systemTime;
    @NotBlank
    private Codes code;
    @NotBlank
    private ErrorCodes errorCode;
    @NotBlank
    private ErrorMessages errorMessage;
}
