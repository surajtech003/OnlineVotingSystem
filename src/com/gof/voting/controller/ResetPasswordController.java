package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.service.LoginService;
import com.gof.voting.service.RestePassService;
import com.gof.voting.serviceImpl.LoginServiceImpl;
import com.gof.voting.serviceImpl.ResetPassServiceImpl;

/**
 * Servlet implementation class ResetPasswordController
 */
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("inside reset controller");
		System.out.println("inside reset Password  controller ");
		
		String email = request.getParameter("email");
		String password = request.getParameter("newPass");
		
		
		//out.println(newPassword+" "+cnfPassword);
		RestePassService resetPassService = new ResetPassServiceImpl();
		boolean isUpdate = resetPassService.updateResetPassword(email,password);
		System.out.println("password updated successfully"+isUpdate);
		
		out.close();
	}

}
