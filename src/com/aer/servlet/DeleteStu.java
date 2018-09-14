package com.aer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aer.dao.StudentDao;
import com.aer.dao.imp.StudentDaoImp;
import com.aer.util.Judge;

public class DeleteStu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		if (Judge.isNotEmpty(idStr)) {
			id = Integer.valueOf(idStr);
		}
		StudentDao dao = new StudentDaoImp();
		Object[] params = {id};
		int row = dao.deleteStu(params);
		String msg2 = "删除失败";
		if (row==1) {
			msg2 = "删除成功";
		}
		request.setAttribute("msg2", msg2);
		request.getRequestDispatcher("selectstu").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
