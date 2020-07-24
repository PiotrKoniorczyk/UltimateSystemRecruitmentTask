package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.controler.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderDto {
    private long id;
    private String productName;
    private String name;
    private String surname;
    private LocalDateTime created;
}
