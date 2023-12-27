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
@WebServlet("/SaveServlet") // Annotation to define the servlet mapping
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// general setting
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter(); // PrintWriter to send the response to the client
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Emp e = new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status = EmpDao.save(e); // Calling the save() method from EmpDao to save the Emp instance to the database
		if(status>0) {
			writer.println("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response); // Including index.html in the response
		}
		else {
			writer.println("Sorry! Unable to save record ");
		}
		writer.close();
		
		
	}

}
