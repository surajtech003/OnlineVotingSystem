package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.service.LoginService;
import com.gof.voting.serviceImpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//out.println("inside login controller");
		System.out.println("inside login controller ");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		LoginService loginService = new LoginServiceImpl();
		boolean validationFlag = loginService.getLoginDetails(userName, password);
		if(validationFlag){                
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("True");
		}
		System.out.println(validationFlag);
		out.close();
	}
}
