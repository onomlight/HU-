package com.korea1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.korea1.domain.Criteria;
import com.korea1.domain.ReplyVO;

public interface ReplyMapper {

	//등록
	public int insert(ReplyVO vo);
	
	//조회
	public ReplyVO read(Long rno);
	
	//수정
	public int update(ReplyVO reply);
	
	//삭제
	public int delete(Long rno);
	
	//페이징 처리
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	//댓글개수 가져오기
	public int getCountByBno(Long bno);
}
