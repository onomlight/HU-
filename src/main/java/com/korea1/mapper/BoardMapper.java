package com.korea1.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.korea1.domain.BoardVO;
import com.korea1.domain.Criteria;
import com.korea1.domain.SampleDTO;

public interface BoardMapper {

	Class<?> Integer = null;

	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	
	public List<BoardVO> getListXML();
	
	
	public void insertXML(BoardVO board);
	
	@Insert
	("insert into tbl_board(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public void insert(BoardVO board);
	

	@SelectKey
	(
			statement="select seq_board.currval from dual",
			keyProperty="bno",
			before=false,
			resultType=long.class
	)
	@Insert
	("insert into tbl_board(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public long insertSelectKey(BoardVO board);
	
	
	
	public long insertSelectKeyXML(BoardVO board);
	
	
	@Select("select * from tbl_board where bno=#{bno}")
	public BoardVO read(Long bno);
	
	public BoardVO readXML(Long bno);
	
	
	@Delete("delete from tbl_board where bno=#{bno}")
	public int delete (Long bno);
	
	public int deleteXML(Long bno);
	
	
	@Update
	("update tbl_board set title=#{title},content=#{content},writer=#{writer},updateDate=sysdate where bno=#{bno}")
	public int update(BoardVO board);
	
	public int updateXML(BoardVO board);
	
 
	public  List<BoardVO> getListWithPaging(Criteria cri); 
	
	@Select("select count(*) from tbl_board where bno>0")
	public int getTotalCount(Criteria cri);
	
	
	 

	public int test(Map<String, Object> map);

}
