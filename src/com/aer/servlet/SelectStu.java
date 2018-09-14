package com.aer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aer.dao.StudentDao;
import com.aer.dao.imp.StudentDaoImp;

public class SelectStu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		StudentDao dao = new StudentDaoImp();
		List list = dao.selectStu();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/student/selectstu.jsp").forward(request, response);
	}

}
