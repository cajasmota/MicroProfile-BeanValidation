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

    @Size(min = 6)
    @NotNull(message = "El nombre del libro es obligatorio")
    private String name;

    @NotNull(message = "El autor es obligatorio")
    private String author;

    @Min(value = 6, message = "El libro puede tener 6 páginas como mínimo")
    @Max(value = 200, message = "El libro puede tener 200 paginas como máximo")
    @NotNull(message = "Debe de ingresar un número de paginas")
    private Integer pages;
}
