package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.email.SenderMail;
import com.gof.voting.service.RestePassService;
import com.gof.voting.serviceImpl.ResetPassServiceImpl;

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
		out.println("inside mail- controller");
		String toMail = request.getParameter("senderMail");
		RestePassService resetPassService = new ResetPassServiceImpl();
		boolean isExistMailId = resetPassService.validateMail(toMail);
		System.out.println(isExistMailId+"::is existed in database");
		//System.out.println(toMail);
		if (!isExistMailId) {
			out.println(toMail + "- is not existed in database please try wit correct mail id.");
			response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("False");
		}
		System.out.println("In side mail controller");
		out.close();

	}

}
