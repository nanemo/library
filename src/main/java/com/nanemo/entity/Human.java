package com.nanemo.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Human {
    private Integer humanId;
    private String name;
    private LocalDate birthdate;
    private List<Book> bookList;
}
