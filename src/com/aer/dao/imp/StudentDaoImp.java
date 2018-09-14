package com.aer.dao.imp;

import java.util.List;

import com.aer.dao.StudentDao;
import com.aer.util.BaseDao;

public class StudentDaoImp implements StudentDao {

	@Override
	public int addStu(Object[] params) {
		String sql = "insert student (xname) values (?)";
		int row = BaseDao.insertAndDeleteAndUpdate(sql, params);
		return row;
	}

	@Override
	public List selectStu() {
		String sql = "select id,xname from student";
		List list = BaseDao.selectList(sql, null);
		return list;
	}

	@Override
	public int deleteStu(Object[] params) {
		String sql = "delete from student where id = ?";
		int row = BaseDao.insertAndDeleteAndUpdate(sql, params);
		return row;
	}

	@Override
	public List mapStu(Object[] params) {
		String sql = "select xname from student where id = ?";
		List list = BaseDao.selectMap(sql, params);
		return list;
	}

	@Override
	public int editStu(Object[] params) {
		String sql = "update student set xname = ? where id = ?";
		int row = BaseDao.insertAndDeleteAndUpdate(sql, params);
		return row;
	}

}
