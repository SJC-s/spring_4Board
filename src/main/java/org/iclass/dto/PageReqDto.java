package org.iclass.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageReqDto {
	private int page = 1; // 요청 페이지
	private int pageSize = 10; // 페이지의 글 개수
	private int startNo; // 페이지 글 목록의 시작 rownum
	private int endNo; // 페이지 글 목록의 끝 rownum
	
	// 페이지리스트를 위한 속성(서비스에서 계산)
	private int totalPages;
	private int totalCount;
	private int startPage;
	private int endPage;
	
	// 검색을 위한 속성
	private String column;
	private String keyword;
	
	private PageReqDto() { }
	
	public static PageReqDto of(int page, int pageSize) {
		PageReqDto dto = new PageReqDto();
		dto.setPage(page);
		dto.setPageSize(pageSize);
		return dto;
	}
}
