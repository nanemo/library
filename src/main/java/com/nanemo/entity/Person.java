package com.nanemo.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer personId;
    private String name;
    private LocalDate birthdate;
    private List<Book> bookList;
}
