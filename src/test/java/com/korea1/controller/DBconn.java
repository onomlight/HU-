package com.korea1.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DBconn {

	
	@Test
	public void test() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "c##book_ex";
		String pw = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url,id,pw);
			log.info("conn's obj : " + conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
