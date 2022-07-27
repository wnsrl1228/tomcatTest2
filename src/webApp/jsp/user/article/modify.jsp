<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<h1>게시물 수정페이지</h1>

<script>
    function formCheck(form){
        // 쓸때없는 좌우공백 제거
        form.query.value = form.query.value.trim();

        // 길이체크
        if(form.query.value.length == 0){
            alert("입력해주세요");
            form.query.focus;
            return;
        }
        form.submit();
    }
</script>
<div>
    <% if ( article != null ) { %>
    <form method="post" onsubmit="formCheck(this); return false;" action="/user/article/modify/free/<%=article.getId()%>">
        <div>
            ID : <%=article.getId()%>
        </div>
        <div>
            TITLE : <input type="text" name="title" value=<%=article.getTitle()%>>
        </div>
        <div>
            BODY : <input type="text" name="body" value=<%=article.getBody()%>>
        </div>
        <input type="submit" value="수정">
    </form>
    <% } %>
</div>
<a href="/user/article/list" >글 목록 보기</a>