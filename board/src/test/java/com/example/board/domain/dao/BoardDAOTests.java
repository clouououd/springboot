package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTests {
    @Autowired
    private BoardDAO boardDAO;

    // 게시글 목록
    @Test
    public void getListTest(){
        boardDAO.getList(new Criteria(2,10)).stream().map(BoardVO::toString).forEach(log::info);
    }

    // 게시글 등록
    @Test
    public void registerTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("Test");
        boardVO.setBoardContent("Test");
        boardVO.setBoardWriter("Tester");
        boardDAO.register(boardVO);
    }

    // 게시글 상세보기
    @Test
    public void readTest(){
        long boardBno = 2L;
        boardDAO.read(boardBno);
    }

    // 게시글 삭제
    @Test
    public void remove(){
        long boardBno = 2L;
        boardDAO.remove(boardBno);
    }

    // 게시글 수정
    @Test
    public void modifyTest(){
        // 입력받은 보드번호
        Long boardBno = 2L;
        // 해당 보드의 정보 불러오기
        BoardVO boardVO = boardDAO.read(boardBno);
        // 보드가 존재하지 않으면 종료 ... 불필요한 연산을 줄여줌
        if(boardVO == null){log.info("no board"); return;}
        // 수정내용
        boardVO.setBoardTitle("Test");
        boardVO.setBoardContent("Test");
        // 수정
        boardDAO.modify(boardVO);
    }

    // 전체 게시글 수
    @Test
    public void getTotal(){
        log.info("전체 게시글 수 : " + boardDAO.getTotal());
    }
}
