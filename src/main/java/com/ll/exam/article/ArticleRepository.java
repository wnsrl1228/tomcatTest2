package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static long lastId;
    private static List<ArticleDto> datum;

    static {
        datum = new ArrayList<>();
        lastId = 0;
    }
    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);
        return id;

    }

    public List<ArticleDto> findAll() {
        return datum;
    }

    public ArticleDto findById(long id) {
        for ( ArticleDto articleDto : datum){
            if(articleDto.getId() == id){
                return articleDto;
            }
        }
        return null;
    }
}
