package com.ll.exam.article.dto;

import lombok.*;


@AllArgsConstructor
//@Getter
//@Setter
//@ToString  data와 같음
@Data
public class ArticleDto {
    private long id;
    private String title;
    private String body;
}
