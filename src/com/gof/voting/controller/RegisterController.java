package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.model.LoginDetails;
import com.gof.voting.service.RegisterService;
import com.gof.voting.serviceImpl.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("inside register controller");

		System.out.println("In side register controller");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String email = request.getParameter("email");

		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserName(userName);
		loginDetails.setPassword(password);
		loginDetails.setRole(role);
		loginDetails.setEmail(email);

		RegisterService service = new RegisterServiceImpl();
		boolean isRegister = service.registerLogger(loginDetails);
		if(isRegister){                
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("True");
		}
		System.out.println(isRegister);
		System.out.println("done");
		out.close();

	}

}
