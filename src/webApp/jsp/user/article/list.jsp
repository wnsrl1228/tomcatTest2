<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>

        <ul class="mt-5">
            <c:forEach items="${articles}" var="article">
            <li class="flex">
                <a class="w-[40px] hover:underline hover:text-[red]" href="/user/article/detail/free/${article.id}">${article.id}</a>
                <a class="flex-grow hover:underline hover:text-[red]" href="/user/article/detail/free/${article.id}">${article.title}</a>
                <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/user/article/delete/free/${article.id}">삭제</a>
                <a class="hover:underline hover:text-[red]" href="/user/article/modify/free/${article.id}">수정</a>
            </li>
            </c:forEach>
        </ul>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>