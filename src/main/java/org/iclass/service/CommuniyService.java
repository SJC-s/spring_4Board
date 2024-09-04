package org.iclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.dao.CommunityCommentsMapper;
import org.iclass.dao.CommunityMapper;
import org.iclass.dto.CommunityDto;
import org.iclass.dto.PageReqDto;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
//@RequiredArgsConstructor // final 변수 커스텀 생성자를 만든다
public class CommuniyService {
	// 게시판 기능 서비스 - 메인글과 댓글은 하나의 기능 서비스도 1개
	public final CommunityMapper mainDao; 
	public final CommunityCommentsMapper cmtDao;
	
	// 생성자 주입
	public CommuniyService(CommunityMapper mainDao, CommunityCommentsMapper cmtDao) {
		this.mainDao = mainDao;
		this.cmtDao = cmtDao;
	}
	
	// 페이지네이션+검색 기능으로 글목록 생성
	public Map<String, Object> pageSearchList(int page) {
		// 현재 페이지를 전달받아 해당 글목록을 만든다
		// 한 페이지 10개씩 보여주기
		PageReqDto pageDto = PageReqDto.of(page, 10);
		List<CommunityDto> list = mainDao.getList(pageDto);
		Map<String, Object> map = new HashMap<>();
		map.put("pageDto", pageDto);
		map.put("list", list);
		return map;
	}
	
}
