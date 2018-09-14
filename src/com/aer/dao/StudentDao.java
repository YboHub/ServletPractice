package com.aer.dao;

import java.util.List;


public interface StudentDao {

	int addStu(Object[] params);

	List selectStu();

	int deleteStu(Object[] params);

	List mapStu(Object[] params);

	int editStu(Object[] params);

}
