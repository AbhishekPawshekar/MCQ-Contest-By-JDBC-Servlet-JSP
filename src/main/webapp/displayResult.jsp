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
<% ArrayList<Integer> userans=(ArrayList<Integer>)request.getAttribute("userans"); %>
<%ArrayList<ModelSchema_DTO> ms=(ArrayList<ModelSchema_DTO>)request.getAttribute("dataList"); %>

<h1 class="title_subject_text">Test Started</h1>
      <%int i=0; %>
      <%String ans=""; %>
      <form action="submitAnswer" class="container">
      <%for(ModelSchema_DTO dto:ms){ %>
          <div class="question_container">
                    <h2><%= dto.getQuestion() %></h2>
                    <%if(userans.get(i)==1) {%>
                   
                   <div> <input type="radio" readonly checked name="<%= dto.getQues_id() %>" value="1"/><%= dto.getOpt1() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="2" /><%= dto.getOpt2() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="3" /><%= dto.getOpt3() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="4" /><%= dto.getOpt4() %></div>
                    <%}else if(userans.get(i)==2){ %>
                  
                     <div> <input type="radio" readonly name="<%= dto.getQues_id() %>" value="1"/><%= dto.getOpt1() %></div>
                    <div><input type="radio"  readonly checked name="<%= dto.getQues_id() %>" value="2" /><%= dto.getOpt2() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="3" /><%= dto.getOpt3() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="4" /><%= dto.getOpt4() %></div>
                    <%}else if(userans.get(i)==3){ %>
                 
                     <div> <input type="radio"  readonly name="<%= dto.getQues_id() %>" value="1"/><%= dto.getOpt1() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="2" /><%= dto.getOpt2() %></div>
                    <div><input type="radio" readonly checked name="<%= dto.getQues_id() %>" value="3" /><%= dto.getOpt3() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="4" /><%= dto.getOpt4() %></div>
                    <%}else{ %>
                 
                     <div> <input type="radio" readonly name="<%= dto.getQues_id() %>" value="1"/><%= dto.getOpt1() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="2" /><%= dto.getOpt2() %></div>
                    <div><input type="radio" readonly name="<%= dto.getQues_id() %>" value="3" /><%= dto.getOpt3() %></div>
                    <div><input type="radio"  readonly checked name="<%= dto.getQues_id() %>" value="4" /><%= dto.getOpt4() %></div>
                    <%}%>
                    <%switch(dto.getAnskey()){
                    case 1:ans=dto.getOpt1();
                    break;
                    case 2:ans=dto.getOpt2();
                    break;
                    case 3:ans=dto.getOpt3();
                    break;
                    case 4:ans=dto.getOpt4();
                    default:ans="";
                    break;
                    } %>
                    <%if(userans.get(i)==dto.getAnskey()){ %>
          			<h1 style="width:70%;text-align:center;color:white;background-color:green;border-radius:30px">Correct Option is :<%=ans%></h1>
          			<%}else{%>
          			 <h1 style="width:70%;text-align:center;color:white;background-color:tomato;border-radius:30px">Correct Option is : <%=ans %></h1>
          			<%i++; %>
          			<%} %>
          </div>
          <%}%>
          <input type="submit" value="submit"/>
          </form>
</body>
</html>