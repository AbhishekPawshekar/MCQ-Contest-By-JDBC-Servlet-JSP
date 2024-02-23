<%@page import="Model.ModelSchema_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./startTest_CSS.css">
</head>
<body>
<%ArrayList<ModelSchema_DTO> ms=(ArrayList<ModelSchema_DTO>)request.getAttribute("dataList"); %>
 <h1 class="title_subject_text">Test Started</h1>
      
      <form action="submitAnswer" class="container">
      <%for(ModelSchema_DTO dto:ms){ %>
          <div class="question_container">
                    <h2><%= dto.getQuestion() %></h2>
                   <div> <input type="radio" name="<%= dto.getQues_id() %>" value="1" id="" onchange="checkAns(<%= dto.getAnskey()%>,1,<%= dto.getQues_id() %>)"/><%= dto.getOpt1() %></div>
                    <div><input type="radio" name="<%= dto.getQues_id() %>" value="2" id=""onchange="checkAns(<%= dto.getAnskey()%>,2,<%= dto.getQues_id() %>)"/><%= dto.getOpt2() %></div>
                    <div><input type="radio" name="<%= dto.getQues_id() %>" value="3" id=""onchange="checkAns(<%= dto.getAnskey()%>,3,<%= dto.getQues_id() %>)"/><%= dto.getOpt3() %></div>
                    <div><input type="radio" name="<%= dto.getQues_id() %>" value="4" id=""onchange="checkAns(<%= dto.getAnskey()%>,4,<%= dto.getQues_id() %>)"/><%= dto.getOpt4() %></div>
          <h1 id="ansStatus<%= dto.getQues_id() %>" style="width:70%;text-align:center;background-color:white;border-radius:30px"></h1>
          </div>
          <%}%>
          <input type="submit" value="submit"/>
          </form>
     
<script src="./checkAnsJavaScript.js"></script>
</body>
</html>