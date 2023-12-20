package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UsersDao;
import com.sunbeam.pojos.Users;
import com.sunbeam.utils.DateUtil;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		String mobile = req.getParameter("mobile");
		String dob = req.getParameter("dob");
		
		java.util.Date jdate = DateUtil.parse(dob);
		
		Users user = new Users(1, fname, lname, email, passwd, mobile, jdate);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sign Up Status</title>");
		out.println("</head>");
		out.println("<body>");
		
		try(UsersDao udao = new UsersDao()){
			int cnt = udao.signUp(user);
			
			if(cnt == 1) {
				out.println("<h3>SignUp Successfull!!</h3>");
				out.println("<a href='index.html'>LogIn</a>");
			}
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
