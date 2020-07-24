package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private String name;
    private String surname;
    private LocalDateTime created;
}

