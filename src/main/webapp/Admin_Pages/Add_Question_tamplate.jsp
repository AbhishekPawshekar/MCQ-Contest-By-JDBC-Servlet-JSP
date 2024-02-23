<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
                    input{width: 100%;}
                    form div{display: flex;flex-direction: row;}
                    #addquestion{background-color:orange;color:white;padding:10px}
                    #submit{background-color:green;color:white;padding:10px;margin-Left:10px}
          </style>
</head>
<body>

 <div style="display:flex;flex-direction:row;align-items:center;justify-content:space-around;flex-wrap:wrap;">
                   <h1 style="background-color: black;color:white; width: 100%;text-align:center;padding:20px">Question Stack</h1>
          <form action="add_question_database" style="margin-top:10px;display: flex;flex-direction:column;justify-content:space-around;align-items:center;gap:10px;width:70%;height:auto">
                              <input type="text" name="question_title" readonly value=<%= request.getAttribute("title") %> />
                               <input type="text" name="question"  placeholder="Question"/>
                              <div> <input type="radio" name="op" value="1"/><input type="text" name="op1"  placeholder="Enter Option 1"/></div>
                              <div><input type="radio" name="op" value="2"/><input type="text" name="op2" id="" placeholder="Enter Option 2"/></div>
                              <div> <input type="radio" name="op" id="" value="3"/><input type="text" name="op3" id="" placeholder="Enter Option 3"/></div>
                               <div><input type="radio" name="op" id="" value="4"/><input type="text" name="op4" id="" placeholder="Enter Option 4"/></div>
                               <label for="difflevel">Difficulty Level</label>
                               <div style="display: flex;flex-direction:row;">
                                         <input type="radio" name="difflevel" id="" value="easy">Easy
                                         <input type="radio" name="difflevel" id="" value="medium">Medium
                                         <input type="radio" name="difflevel" id="" value="hard">Hard
                               </div>
                     <div>
                               <input id="addquestion" type="submit" value="addquestion" name="operation">
                               <input id="submit" type="submit" value="submit" name="operation">
                     </div>
          </form>
          </div>
</body>
</html>