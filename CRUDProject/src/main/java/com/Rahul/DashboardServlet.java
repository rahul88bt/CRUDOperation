package com.Rahul;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addData")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displaydata.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("displaydata.jsp");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		PrintWriter out=response.getWriter();
		RequestDao r=new RequestDao();
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		r.insertData(user);
		response.sendRedirect("displaydata.jsp");
	}

}
