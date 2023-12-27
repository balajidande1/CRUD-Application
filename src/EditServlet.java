package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.Emp;
import com.hcl.EmpDao;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// general setting
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.println("<h1> Update Employee</h1>");
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Emp e = EmpDao.getEmployeeById(id);
		
		writer.print("<form action='EditServlet2' method='post'>");
		writer.print("<input type='hidden' name='id' value='"+e.getId()+"'/>");
		writer.print("Name: <input type='text' name='name' value='"+e.getName()+"'/>");
		writer.print("Password: <input type='password' name='password' value='"+e.getPassword()+"'/>");
		writer.print("Email: <input type='email' name='email' value='"+e.getEmail()+"'/>");
		writer.print("Country: ");
		writer.print("<select name='country' style='width:150px'>");
		writer.print("<option>India</option>");
		writer.print("<option>USA</option>");
		writer.print("<option>UK</option>");
		writer.print("<option>Other</option>");
		writer.print("</select>");
		writer.print("<input type='submit' value='Edit & Save'/>");
		writer.print("</form>");
		
		writer.close();
		
	}
}
