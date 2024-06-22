package com.lifung.todolistservice.dto;

import com.lifung.todolistservice.exception.ErrorCode;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionResponseDto {

  private String message;
  private ErrorCode code;
}
