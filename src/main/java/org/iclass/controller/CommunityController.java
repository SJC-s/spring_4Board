package org.iclass.controller;

import java.util.Map;

import org.iclass.dto.CommunityDto;
import org.iclass.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private final CommunityService service;
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int page, String columns, String Keyword, Model model) { 
		Map<String,Object> map = service.pageSearchList(page);
		model.addAttribute("pageDto", map.get("pageDto"));
		model.addAttribute("list", map.get("list"));
		return "community/list";
	}
	
	// 글쓰기 폼 화면 보여주기
	@GetMapping("/write") // 
	public String write(@RequestParam(defaultValue = "1") int page, Model model) {
		model.addAttribute("page", page);
		return "community/write";
	}
	@PostMapping("/write") // 글 저장 후 글 목록으로 url 이동
	public String write(CommunityDto dto, RedirectAttributes reAttr) {
		log.info("글쓰기 입력 dto : {}", dto);
		service.write(dto);
		reAttr.addFlashAttribute("message", "글이 등록되었습니다");
		return "redirect:list";
	}
	
	
	@GetMapping("/modify") // 글 수정 화면
	public String modify(int idx, @RequestParam(defaultValue = "1") int page, Model model) {
		CommunityDto dto = service.selectByIdx(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		return "community/modify";
	}
	@PostMapping("/modify") // 글 수정 저장 후 글 목록(또는 수정)으로 url 이동
	public String modify(@RequestParam(defaultValue = "1") int page, CommunityDto dto, RedirectAttributes reAttr) { //Model model) {
		service.modify(dto);
//		model.addAttribute("idx", dto.getIdx());
//		model.addAttribute("page", page);
		reAttr.addAttribute("idx", dto.getIdx());
		reAttr.addAttribute("page", page);
		reAttr.addFlashAttribute("message", "글이 수정되었습니다");
//		return "redirect:list";
//		return "redirect:modify";
		return "redirect:read";
	}
	
	@GetMapping("/read") // 
	public String read(int idx, @RequestParam(defaultValue = "1") int page, Model model) {
		CommunityDto dto = service.readOne(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		return "community/read";
	}
	
	@PostMapping("/remove") // 글 삭제 후 글 목록으로 url 이동
	public String remove(int idx, int page, RedirectAttributes reAttr) {
		// RedirectAttributes : 리다이렉트 동작에 애트리뷰트 값을 사용하도록 지원하는 인터페이스
		// - 리다이렉트 url의 컨트롤러에서는 사용 못하고 view로 전달해 준다
		// addFlashAttribute 메소드 : 
		// - Model 애트리뷰트는 url에 보인다, 이 메소드 애트리뷰트는 url 표시 X
		// 
		service.remove(idx);
		reAttr.addAttribute("page", page);
		reAttr.addFlashAttribute("message", "글이 삭제되었습니다");
		return "redirect:list";
	}
	
}
