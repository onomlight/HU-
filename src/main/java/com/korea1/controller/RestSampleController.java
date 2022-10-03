package com.korea1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea1.domain.RestSampleVO;
import com.korea1.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/restsample")
@Log4j
public class RestSampleController {
	
	@GetMapping
	(
			value="/getText", 
			produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public RestSampleVO test1() {

		return new RestSampleVO(112,"스타","로드");
		
	}
	
	@GetMapping("/getText2")
	public RestSampleVO test2() {
		
		return new RestSampleVO(113,"로켓","라쿤"); 
	}
	
	@GetMapping("/getText3")
	public List<RestSampleVO> test3(){
		
		List<RestSampleVO> list = new ArrayList();
		RestSampleVO vo=null;
		for(int i=0;i<10;i++) {
			vo = new RestSampleVO();
			vo.setFirstName(i+"홍");
			vo.setLastName("길동" + i);
			vo.setMno(i);
			list.add(vo);
		}	
		return list;
	}
	
	@GetMapping(value="/check",params= {"height","weight"})
	public ResponseEntity<RestSampleVO> check(Double height, Double weight)
	{
		RestSampleVO vo = new RestSampleVO(0,"" + height,""+weight);
		
		ResponseEntity<RestSampleVO> result = null;
		
		if(height<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
			
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid)
	{
		String [] list = {"category : " +cat, "productid : " + pid};
		return list;
	}
	
	
	
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert....ticket"  + ticket);
		return ticket;
	}
	
	
}





