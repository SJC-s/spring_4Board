package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.dto.CommunityDto;
import org.iclass.dto.PageReqDto;

@Mapper
public interface CommunityMapper {
	// 인터페이스 추상메소드 선언
	// mapper xml의 id와 같은 이름의 메소드로, 리턴과 파라미터(메소드 인자) 타입도 동일하게
	int insert(CommunityDto dto);
	int update(CommunityDto dto);
	int delete(int idx);
	CommunityDto selectByIdx(int idx);
	int getCount();
	int getCommentCount(int idx);
	int setReadCount(int idx);
	int setCommentCount(int idx);
	List<CommunityDto> getList(PageReqDto dto);
}
