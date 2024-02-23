package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DataBaseOperation;
import Model.ModelSchema_DTO;

@WebServlet(urlPatterns = {"/Admin_Pages/addQuestionTitle","/Admin_Pages/add_question_database","/mcqOn","/submitAnswer"})
public class Controller_Servlet extends HttpServlet {

	private static Connection connection;
	private static ArrayList<ModelSchema_DTO> list_data;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","pawshekar");
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/Admin_Pages/addQuestionTitle":
			sendTitleToQuestionTemplate(req,resp);
			break;
		case "/Admin_Pages/add_question_database":
			AddData_to_Database(req,resp);
			break;
		case "/mcqOn":
			fetchMcqOn(req,resp);
			break;
		case "/submitAnswer":
			submitAnswer(req,resp);
			break;
		}
	}

	private void submitAnswer(HttpServletRequest req, HttpServletResponse resp) {
		int count=0;
		ArrayList<Integer> userans=new ArrayList<Integer>();
		for(ModelSchema_DTO dto:list_data) {
			String anskey=req.getParameter(dto.getQues_id()+"");
			userans.add(Integer.parseInt(anskey));
			if(Integer.parseInt(anskey)==dto.getAnskey()) 
				count++;
			RequestDispatcher rd=req.getRequestDispatcher("displayResult.jsp");
			req.setAttribute("userans", userans);
			req.setAttribute("dataList", list_data);
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(count);
		
	}

	private void fetchMcqOn(HttpServletRequest req, HttpServletResponse resp) {
		String title=req.getParameter("title");
		RequestDispatcher rd=req.getRequestDispatcher("startTest.jsp");
		list_data=new DataBaseOperation().getdataFromDataset(connection, title);
		req.setAttribute("dataList",list_data );
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void AddData_to_Database(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DataBaseOperation db=new DataBaseOperation();
		String title=req.getParameter("question_title");
		String question=req.getParameter("question");
		String ans_key=req.getParameter("op");
		String opt1=req.getParameter("op1");
		String opt2=req.getParameter("op2");
		String opt3=req.getParameter("op3");
		String opt4=req.getParameter("op4");
		String difflevel=req.getParameter("difflevel");
		String operation=req.getParameter("operation");
		if(operation.contentEquals("addquestion")) {
			ModelSchema_DTO ms=new ModelSchema_DTO();
			ms.setQues_id(0);
			ms.setQuestion_title(title);
			ms.setQuestion(question);
			ms.setAnskey(Integer.parseInt(ans_key));
			ms.setOpt1(opt1);
			ms.setOpt2(opt2);
			ms.setOpt3(opt3);
			ms.setOpt4(opt4);
			ms.setDiff_level(difflevel);
			db.add_to_list(ms);
		try {
			RequestDispatcher rd=req.getRequestDispatcher("Add_Question_tamplate.jsp");
			req.setAttribute("title", title);
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			}
		}
		else {
			
			if(db.addDataToDataBase(connection)) {
				PrintWriter pw=resp.getWriter();
				pw.print("<h1>Successfully added to database...!!!</h1>");
			}
		}
	}

	private void sendTitleToQuestionTemplate(HttpServletRequest req, HttpServletResponse resp) {
		String title=req.getParameter("title");
		RequestDispatcher rd=req.getRequestDispatcher("Add_Question_tamplate.jsp");
		req.setAttribute("title", title);
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
