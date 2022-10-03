package com.korea1.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea1.domain.Criteria;
import com.korea1.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void InsertTest() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(110L);
		vo.setReply("댓글테스트1");
		vo.setReplyer("writer1");
		mapper.insert(vo);
	}
	
	@Test
	public void ReadTest() {
		ReplyVO vo = mapper.read(1L);
		log.info("read : " + vo);
	}
	
	@Test
	public void UpdateTest() {
		ReplyVO vo = mapper.read(1L);
		vo.setReply("UpdateTest");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT : " + count);
	}
	
	
	@Test
	public void DeleteTest() {
		mapper.delete(2L);
	}
	
	@Test
	public void CreateReply2() {
		long bnolist[] = {110L,112L,118L};
		ReplyVO vo = new ReplyVO();
		
		for(int i=0;i<bnolist.length;i++) {
			
			for(int j=0;j<5;j++) {
				vo.setBno(bnolist[i]);
				vo.setReply("테스트"+j);
				vo.setReplyer("작성자"+i);
				mapper.insert(vo);
			}
		}
	}
	@Test
	public void getListPage(){
		Criteria cri = new Criteria();	 
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 112L);
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	
	
	
	
}
