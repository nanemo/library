package com.nanemo.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private LocalDate releaseDate;
    private Person person;
}
