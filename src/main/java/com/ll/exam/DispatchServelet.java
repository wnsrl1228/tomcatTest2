package com.ll.exam;


import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/*")
public class DispatchServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI(); // 주소만 가져옴

        System.out.printf(url);
        Rq rq = new Rq(req, resp);
        switch (url){
            case "/user/article/list/free":
                System.out.printf("안녕");
                articleController.showList(rq);
                break;
            case "/user/article/list/write":
                articleController.showWrite(rq);
                break;
            case "/user/member/login":
                memberController.showList(rq);
                break;
        }
    }
}
