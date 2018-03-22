package com.gof.voting.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gof.voting.model.VotingMenu;
import com.gof.voting.service.VotingService;
import com.gof.voting.serviceImpl.VotingServiceImpl;

/**
 * Servlet implementation class VotingController
 */
public class VotingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("welcome voting action:");
		VotingService votingService = new VotingServiceImpl();
		List<VotingMenu> listVotingDetails = null;
		try {
			listVotingDetails = votingService.getVotingDetails();
			for (VotingMenu votingMenu : listVotingDetails) {
				System.out.println("In controller======================");
				System.out.print(votingMenu.getSerialNumber() + " ");
				System.out.print(votingMenu.getPartyName() + " ");
				System.out.print(votingMenu.getSymbol() + " ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		out.close();
	}
}
