package com.korea1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea1.domain.BoardVO;
import com.korea1.domain.Criteria;
import com.korea1.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

 
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		//mapper.insertXML(board);
		mapper.insertSelectKeyXML(board);
	}
	@Override
	public BoardVO get(Long bno) {
		return mapper.readXML(bno);
	}
	@Override
	public boolean modify(BoardVO board) {
		int result = mapper.updateXML(board);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean remove(Long bno) {
		int result = mapper.deleteXML(bno);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
	}
//	@Override
//	public List<BoardVO> getList() {
//		return mapper.getList();
//	}
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria : " + cri);
		return mapper.getListWithPaging(cri);
	}
	
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}		
}


