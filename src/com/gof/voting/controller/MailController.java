package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.email.SenderMail;

/**
 * Servlet implementation class RegisterController
 */
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("inside mail controller");
		String toMail = request.getParameter("senderMail");
		//System.out.println(toMail);
		SenderMail senderMail = new SenderMail();
		senderMail.sendMail(toMail);
		
		System.out.println("In side mail controller");

		
		out.close();

	}

}
