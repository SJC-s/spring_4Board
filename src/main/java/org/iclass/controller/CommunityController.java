package org.iclass.controller;

import java.util.Map;

import org.iclass.dto.CommunityDto;
import org.iclass.service.CommuniyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private final CommuniyService service;
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int page, String columns, String Keyword, Model model) { 
		Map<String,Object> map = service.pageSearchList(page);
		model.addAttribute("pageDto", map.get("pageDto"));
		model.addAttribute("list", map.get("list"));
		return "community/list";
	}
	
	// 글쓰기 폼 화면 보여주기
	@GetMapping("/write") // 
	public String write(@RequestParam(defaultValue = "1") int page) {
		return "community/write";
	}
	@PostMapping("/write") // 
	public String write(CommunityDto dto, Model model) {
		return "redirect:community/list";
	}
	
	
	@GetMapping("/modify") // 
	public String modify(int page) {
		return "community/modify";
	}
	@PostMapping("/modify") // 
	public String modify(CommunityDto dto, Model model) {
		return "redirect:modify";
	}
	
	@GetMapping("/read") // 
	public String read(int idx, @RequestParam(defaultValue = "1") int page, Model model) {
		return "community/read";
	}
	
	@PostMapping("/remove") // 
	public String remove(int idx, int page) {
		return "redirect:community/list";
	}
	
}
