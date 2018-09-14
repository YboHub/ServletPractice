package com.aer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aer.dao.StudentDao;
import com.aer.dao.imp.StudentDaoImp;

public class AddStu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/student/addstu.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String xname = request.getParameter("xname");
		StudentDao dao = new StudentDaoImp();
		Object[] params = {xname};
		int row = dao.addStu(params);
		String msg1 = "添加失败";
		if (row==1) {
			msg1 = "添加成功";
		}
		request.setAttribute("msg1", msg1);
		request.getRequestDispatcher("selectstu").forward(request, response);
	}

}
