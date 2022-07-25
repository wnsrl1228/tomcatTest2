package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(1,"제목","내용"));
        articleDtos.add(new ArticleDto(2,"제목","내용"));
        articleDtos.add(new ArticleDto(3,"제목","내용"));
        rq.setAttr("articles",articleDtos);
        rq.view("user/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("user/article/write");
    }
}
