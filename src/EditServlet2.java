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
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// general setting
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status = EmpDao.update(e);
		if(status>0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			writer.println("Sorry! unable to update record");
		}
		
		writer.close();
	}

}
