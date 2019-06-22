package com.demo.models;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data //Lombok's @Data generates Getters and Setters automatically
public class Book
{
    private Long id;

    @NotNull
    @Size(min = 6)
    private String name;

    @NotNull
    private String author;

    @Min(6)
    @Max(200)
    @NotNull
    private Integer pages;
}
