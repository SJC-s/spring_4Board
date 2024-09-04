package spring_4Board;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.iclass.service.CommuniyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/applicationContext.xml")
@Slf4j
public class CommunityServiceTest {
	
	@Autowired
	CommuniyService service;
	
	@DisplayName("서비스 자동주입 확인하기")
	@Test
	void test() {
		assertNotNull(service);
	}
	
	@DisplayName("페이지 목록 자겨오기")
	@Test
	void list() {
		// 페이지 번호로 인자로 전달하기
		Map<String, Object> map = service.pageSearchList(3);
		log.info("===> 페이지 정보와 목록 : {}",map);
		
	}
}
