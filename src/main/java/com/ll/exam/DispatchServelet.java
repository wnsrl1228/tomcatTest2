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

        Rq rq = new Rq(req, resp);
        System.out.println(rq.getMethod());
        System.out.println(rq.getActionPath());
        switch (rq.getMethod()){
            case "GET":
                switch (rq.getActionPath()){
                    case "/user/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/user/article/list":
                        articleController.showList(rq);
                        break;
                    case "/user/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/user/article/delete":
                        articleController.showDelete(rq);
                        break;
                    case "/user/article/modify":
                        articleController.showModify(rq);
                        break;
                    case "/user/member/login":
                        memberController.showList(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getActionPath()){
                    case "/user/article/write":
                        articleController.doWrite(rq);
                        break;
                    case "/user/article/modify":
                        articleController.doModify(rq);
                        break;
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
