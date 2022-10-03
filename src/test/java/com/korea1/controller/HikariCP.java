package com.korea1.controller;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HikariCP {

	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
		try {
			Connection conn = ds.getConnection();
			log.info("conn's obj :" + conn);
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}

}
