<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<% 
 String[] movies = {"겨울왕국II","블랙머니","신의 한수"};
 String movieHTML = "";
 movieHTML="<select id ='movie'>";
 for(String m : movies){
	 movieHTML += "<option>"+m+"</option>";
 }
 movieHTML +="</select>";
 out.print(movieHTML);
%>