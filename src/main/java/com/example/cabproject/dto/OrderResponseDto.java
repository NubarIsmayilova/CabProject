package com.example.cabproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderResponseDto {

    private String from;
    private String to;
}
