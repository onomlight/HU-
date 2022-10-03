package com.korea1.service;

import java.util.List;

import com.korea1.domain.Criteria;
import com.korea1.domain.ReplyPageDTO;
import com.korea1.domain.ReplyVO;

public interface ReplyService {

	//등록
	public int register(ReplyVO vo);
	//조회
	public ReplyVO get(Long rno);
	//수정
	public int modify(ReplyVO vo);
	//삭제
	public int remove(Long rno);
	//페이징
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	//댓글 수 처리
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
}
