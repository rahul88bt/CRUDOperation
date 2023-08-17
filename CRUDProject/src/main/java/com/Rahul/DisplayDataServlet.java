package com.Rahul;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DisplayDataServlet")
public class DisplayDataServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao r=new RequestDao();
		User user=new User();
		ArrayList<User> userList=r.displayAllUser(); 
		request.setAttribute("userList", userList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displaydata.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		RequestDao r=new RequestDao();
		r.deleteData(id);
		response.sendRedirect("/CRUDProject/DisplayDataServlet");
	}

}
