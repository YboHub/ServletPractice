package com.aer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseDao {
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/school?user=root&&password=xc333";
	public static Connection con = null;
	public static PreparedStatement pre = null;
	public static ResultSet rs = null;
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void setParams(Object[] params){
		if (params==null) return;
		for (int i = 0; i < params.length; i++) {
			try {
				pre.setObject(i+1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void closeAll(){
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pre!=null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int insertAndDeleteAndUpdate(String sql,Object[] params){
		int row = 0;
		con = getConnection();
		try {
			pre = con.prepareStatement(sql);
			setParams(params);
			row = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return row;
	}
	
	public static int getBackId(String sql,Object[] params){
		int id = 0;
		con = getConnection();
		try {
			pre = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParams(params);
			pre.executeUpdate();
			rs = pre.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return id;
	}
	
	public static List selectList(String sql,Object[] params){
		List tableList = new ArrayList();
		con = getConnection();
		try {
			pre = con.prepareStatement(sql);
			setParams(params);
			rs = pre.executeQuery();
			int count = rs.getMetaData().getColumnCount();
			while(rs.next()){
				List rowList = new ArrayList();
				for (int i = 1; i <=count; i++) {
						rowList.add(rs.getObject(i));
				}
				tableList.add(rowList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return tableList;
	}
	
	public static List selectMap(String sql,Object[] params){
		List tableList = new ArrayList();
		con = getConnection();
		try {
			pre = con.prepareStatement(sql);
			setParams(params);
			rs = pre.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			int count = rsm.getColumnCount();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <=count; i++) {
					String key = rsm.getColumnName(i);
					Object value = rs.getObject(i);
					map.put(key, value);
				}
				tableList.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return tableList;
	}
	
}
