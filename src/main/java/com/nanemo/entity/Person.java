package com.nanemo.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer personId;
    private String name;
    private String birthday;
    private List<Book> bookList;

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
