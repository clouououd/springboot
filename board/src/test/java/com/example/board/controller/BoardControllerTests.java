package com.example.board.controller;

import com.example.board.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.PortUnreachableException;

@SpringBootTest
@Slf4j
public class BoardControllerTests {
    // 마치 브라우저에서 URL을 요청한 것처럼 환경을 만들어준다.
    private MockMvc mockMvc;

    // 서버 환경 및 설정, 요청 등을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext;

    // 모든 @Test 실행 전 한 번씩 실행된다.
    // @Test 메소드가 2개라면 두 번 실행된다.
    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /* 전체목록 */
    @Test
    public void getListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
                .param("pageNum", "116")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    /* 등록처리 */
    @Test
    public void registerTest() throws Exception {
        log.info("추가된 게시글 번호 : " + mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("boardTitle", "테스트 새 글 제목")
                .param("boardContent", "테스트 새 글 내용")
                .param("boardWriter", "Test")
        ).andReturn().getFlashMap());
    }

    /* 조회 */
    @Test
    public void readTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("boardBno","1155")).andReturn().getModelAndView().getModelMap().toString());
    }

    // 삭제 처리
    @Test
    public void removeTest() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/remove")
                        .param("boardBno", "7")
        ).andReturn().getModelAndView().getViewName());
    }

    /* 수정처리 */
    // 수정 페이지 이동
    @Test
    public void gotoModify() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/modify").param("bno","3")).andReturn().getModelAndView().getModelMap().toString());
    }
    // 수정 완료
    @Test
    public void modify() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("boardBno", "3") // name만 VO와 똑같이 맞춰주면 타입을 알아서 맞춰준다
                .param("boardTitle","수정된 제목")
                .param("boardContent","수정된 내용")
        ).andReturn().getFlashMap().toString());
    }


}
