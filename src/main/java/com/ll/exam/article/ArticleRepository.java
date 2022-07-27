package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static long lastId;
    private static List<ArticleDto> datum;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() {
        IntStream.range(1,10).forEach(id -> {
            String title = "제목%d".formatted(id);
            String body = "내용%d".formatted(id);
            write(title, body);
        });
    }

    public static long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);
        return id;

    }

    public static List<ArticleDto> findAll() {
        return datum;
    }

    public static ArticleDto findById(long id) {
        for ( ArticleDto articleDto : datum){
            if(articleDto.getId() == id){
                return articleDto;
            }
        }
        return null;
    }

    public static void delete(long id) {
        ArticleDto articleDto = findById(id);
        if(articleDto == null){
            return;
        }
        datum.remove(articleDto);
    }

    public static void modify(long id, String title, String body) {
        ArticleDto articleDto = datum.get((int)id);
        articleDto.setTitle(title);
        articleDto.setBody(body);

    }
}
