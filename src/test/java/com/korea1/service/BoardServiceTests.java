package com.korea1.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea1.domain.BoardVO;
import com.korea1.domain.Criteria;
import com.korea1.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	 
	@Autowired
	private BoardService service;
	
	@Test
	public void testFunc() {
		
	log.info(service);
	
	//List<BoardVO> list = service.getList();
	service.getList(new Criteria(2,10)).forEach(board->log.info(board));
	
		 
	}
	
}
