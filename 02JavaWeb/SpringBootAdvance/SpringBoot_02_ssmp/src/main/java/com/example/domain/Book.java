package com.example.domain;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String type;
    private String name;
    private String description;
}
