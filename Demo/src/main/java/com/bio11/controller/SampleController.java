package com.bio11.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bio11.domain.SampleDTO;
import com.bio11.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {
		
	@RequestMapping(value = "/basic", method = {RequestMethod.GET})
	public void basicGet() {
		System.out.println("뜨니?");
		log.info("basic get....");
	}
	
	@GetMapping("/only")
	public void onlyGet() {
		log.info("only get....");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	// 동일한 변수명
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	// 동일한 변수명
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos : " + list);
		return "ex02Bean";
	}
	
	
	@GetMapping("/ex04")
//	public String ex04(SampleDTO dto, int page) { // 이건 page값을 읽어올 수 있으나, 페이지로 넘기려면 model 에 대입해야 함
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {	// 이렇게
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06......");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("conan");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("ex07......");
		
		String msg = String.format("{\"name\":\"conan\"}");
//		String msg2 = String.format("{name : conan}");
		HttpHeaders header = new HttpHeaders(); 
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	// String return 할 경우 /sample 경로를 적어줘야 함 
//	@GetMapping("/exUpload")
//	public String exUpload() {
//		log.info("exUpload....");
//		return "/sample/exUpload";
//	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload....");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		for(MultipartFile file : files) {
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		}
	}
}
