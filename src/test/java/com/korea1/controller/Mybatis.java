package com.korea1.controller;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Mybatis {

 
	@Autowired
	private SqlSessionFactory ssf;
	
	
	@Test
	public void test() {
		try {
			SqlSession dbs = ssf.openSession();
			Connection conn = dbs.getConnection();
			log.info("conn's obj : "+ conn);
		}catch(Exception e) {
		 
			log.error(e.getMessage());
		}
	}

}
