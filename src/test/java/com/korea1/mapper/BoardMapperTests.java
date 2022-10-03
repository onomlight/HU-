package com.korea1.mapper;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea1.domain.BoardVO;
import com.korea1.domain.Criteria;
import com.korea1.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
		
		//mapper.getListXML().forEach(board->log.info(board));
		
//		BoardVO board = new BoardVO();
//		board.setBno(104L);
//		board.setTitle("������ ����2");
//		board.setContent("������ ����2");
//		board.setWriter("������ �ۼ���2");
//		
//		mapper.update(board);
//		mapper.insertXML(board);
//		mapper.insert(board);
//		log.info(board);
		
		
		
//		long bno = mapper.insertSelectKey(board);
//		log.info("bno : " +board.getBno());
		
//		BoardVO board = mapper.read(100L);
//		log.info(board);
		
//		int result = mapper.delete(101L);
//		log.info("result :" + result);
		
 
//		@Autowired
//		private BoardMapper mapper;
		
//		@Autowired
//		private BoardService service;
//		
//		@Test 
//		public void testFunc() {
			 
//			List<BoardVO> list = mapper.getList();
//			
//			list.forEach(dto -> log.info(dto));
			
//			List<BoardVO> list = service.getList();
//			list.forEach(dto -> log.info(dto));
			
//			log.info(service);
//			List<BoardVO> list =service.getList();
			 
//	@Autowired
//	private BoardMapper mapper;
//		@Test
//		public void testgetListWithPaging() {
//			Criteria cri = new Criteria();
//			List<BoardVO>list =mapper.getListWithPaging(cri);
//			list.forEach(board -> log.info(board));
//		}
//			 
//	}
		

	
//	@Autowired
//	private BoardService service;
//	
//	@Test
//	public void testFunc() {
//		
//		log.info(service);
//		
//		service.getList(new Criteria(2,10)).forEach(board->log.info(board));
//	}
		
	//}
//	@Autowired
//	private BoardMapper mapper;
//	
////	@Test
////	public void Test() {
////		List<BoardVO> list = mapper.test("����2");
////		log.info("LIST : " + list);
////	} �����
//	
//	@Test
//	public void getListTest() {
//		List<BoardVO> list = mapper.getList();
//		list.forEach(vo->vo.toString());
//	}
//	
//	@Test
//	public void insertTest() {	
//		BoardVO board = new BoardVO();
//		board.setTitle("8��10��");
//		board.setContent("����9��30��");
//		board.setWriter("�ֹ���");
//		mapper.insert(board);
//		log.info(board);
//	}
//	@Test
//	public void readTest() {
//		BoardVO board = mapper.read(181L);
//		log.info(board);
//	}
//	@Test
//	public void DeleteTest() {
//		int result = mapper.delete(181L);
//		log.info("result : " + result);
//	}
//	@Test
//	public void UpdateTest() {
//		BoardVO board = new BoardVO();
//		board.setBno(183L);
//		board.setTitle("test");
//		board.setContent("������");
//		board.setWriter("�ۼ��� �ֹ���");
//		mapper.update(board);
//		
//	}
//	@Test
//	public void getTotalCountTest() {
//	      Criteria cri = new Criteria();
//
//	        /* �˻����� */
////	        cri.setKeyword("�׽�Ʈ");
//	//
////	        /* �˻� ����Ʈ */
////	        List list = mapper.getTotalCount(cri);
////	        for(int i = 0; i < list.size(); i++) {
////	            System.out.println("result......." + i + " : " + list.get(i));
////	        }
//
//	        /* �Խñ� �� ���� */
//	        int result = mapper.getTotalCount(cri);
//	        System.out.println("�Խñ� �� ����" + result);
	}
	
}
	

