package com.aer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aer.dao.StudentDao;
import com.aer.dao.imp.StudentDaoImp;
import com.aer.util.Judge;

public class EditStu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		if (Judge.isNotEmpty(idStr)) {
			id = Integer.valueOf(idStr);
		}
		StudentDao dao = new StudentDaoImp();
		Object[] params = {id};
		List list = dao.mapStu(params);
		Map map = (Map) list.get(0);
		String sname = (String) map.get("xname");
		request.setAttribute("id", idStr);
		request.setAttribute("sname", sname);
		request.getRequestDispatcher("/WEB-INF/student/editstu.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idStr = request.getParameter("id");
		int id = 0;
		if (Judge.isNotEmpty(idStr)) {
			id = Integer.valueOf(idStr);
		}
		String sname = request.getParameter("sname");
		StudentDao dao = new StudentDaoImp();
		Object[] params = {sname,id};
		int row = dao.editStu(params);
		String msg3 = "修改失败"; 
		if (row==1) {
			msg3 = "修改成功";
		}
		request.setAttribute("msg3", msg3);
		request.getRequestDispatcher("selectstu").forward(request, response);
	}
	

}
