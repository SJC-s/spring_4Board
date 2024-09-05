package org.iclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.dao.CommunityCommentsMapper;
import org.iclass.dao.CommunityMapper;
import org.iclass.dto.CommunityDto;
import org.iclass.dto.PageReqDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		// 페이지리스트 계산을 위한 메소드
		pageDto = makePagination(pageDto);
		List<CommunityDto> list = mainDao.getList(pageDto);
		Map<String, Object> map = new HashMap<>();
		map.put("pageDto", pageDto);
		map.put("list", list);
		return map;
	}
	
	// private : 이 서비스 클래스에서만 사용할 메소드
	private PageReqDto makePagination(PageReqDto pageDto) {
		pageDto.setTotalCount(mainDao.getCount());	
		int currentPage = pageDto.getPage();
		// currentPage는 totalPages 보다 클 수 없고, 1보다 작을 수 없다
		currentPage = Math.max(currentPage, 1);
		
		int pageSize = pageDto.getPageSize();
		int totalpages = (int)Math.ceil((double)pageDto.getTotalCount()/pageSize);
		currentPage = Math.min(currentPage, totalpages);
		
		// 현재 페이지를 기준으로 페이지리스트 시작번호
		// 10 대신에 pageSize
		int startPage = (currentPage-1)/10*10+1;
		// 9 대신에 pageSize-1
		int endPage = Math.min(totalpages, startPage+9);
				
		int startNo = (currentPage-1)*pageSize + 1;
		int endNo = startNo + (pageSize-1);
		
		pageDto.setPage(currentPage);
		pageDto.setStartNo(startNo);
		pageDto.setEndNo(endNo);
		pageDto.setTotalPages(totalpages);
		pageDto.setStartPage(startPage);
		pageDto.setEndPage(endPage);
		
		return pageDto;
	}

	// 글 상세보기 : select, 조회수 증가 update
	@Transactional // 트랜잭션 단위에 해당하는 sql 특히 insert, update, delete를 알아서 commit, rollback을 관리 해주는 애노테이션
	public CommunityDto readOne(int idx) {
		mainDao.setReadCount(idx);
		CommunityDto dto = mainDao.selectByIdx(idx);
		return dto;
	}
	
	// 글 수정할 때 조회수 증가 없이 select 한다
	public CommunityDto selectByIdx(int idx) {
		return mainDao.selectByIdx(idx);
	}
	
	public void write(CommunityDto dto) {
		mainDao.insert(dto);
	}

	public void modify(CommunityDto dto) {
		mainDao.update(dto);
	}

	public void remove(int idx) {
		mainDao.delete(idx);
	}
	
}
