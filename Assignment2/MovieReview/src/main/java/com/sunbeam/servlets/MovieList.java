package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.MoviesDao;
import com.sunbeam.daos.ReviewsDao;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/reviewlist")
public class MovieList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		Users currUser = (Users) session.getAttribute("CurrUser");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Movie List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h4> Hello, " + currUser.getFirstName() + " " + currUser.getLastName()+"</h4><br /><hr />");
		out.println("<center>");
		out.println("<table style='width:600px';>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td><a href=#>All Review</a></td>");
		out.println("<td><a href=#>My Reviews</a></td>");
		out.println("<td><a href=#>Shared Review</a></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</center>");
		out.println("<br />");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<th>Id</th>");
		out.println("<th>Movie Name</th>");
		out.println("<th>Rating</th>");
		out.println("<th>Review</th>");
		out.println("</thead>");
		out.println("<tbody>");
		try(ReviewsDao rdao = new ReviewsDao()){
			List<Reviews> list =  rdao.displayAll();
			
			for(Reviews r : list) {
				out.println("<tr>");
				out.println("<td>" + r.getId() +"</td>");
				try(MoviesDao mdao = new MoviesDao()) {
					Movies m = mdao.findById(r.getMovie_id());
					out.println("<td>" + m.getTitle() +"</td>");
				} catch (Exception e) {
					throw new ServletException(e);
				}
				out.println("<td>" + r.getRating() +"</td>");
				out.println("<td>" + r.getReview() +"</td>");
				out.println("</tr>");
			}
  		} catch(Exception e) {
			throw new ServletException(e);
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</center>");
		out.println("<a href='newreview'>Add Review</a>");
		out.println("<a href='logout' style='float:right';>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
 	}
}
