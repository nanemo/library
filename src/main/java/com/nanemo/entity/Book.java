package com.nanemo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private String releaseDate;
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", personName=" + name +
                '}';
    }
}
