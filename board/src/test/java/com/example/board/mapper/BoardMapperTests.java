package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    // 게시글 목록
    @Test
    public void getListTest(){
        boardMapper.getList(new Criteria(2,10)).stream().map(BoardVO::toString).forEach(log::info);
    }

    // 총 게시글 수
    @Test
    public void getTotalTest(){
        log.info("전체 게시글 수 : " + boardMapper.getTotal());
    }

    // 게시글 등록
    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("Test");
        boardVO.setBoardContent("Test");
        boardVO.setBoardWriter("Tester");
        boardMapper.insert(boardVO);
    }

    // 게시글 상세보기
    @Test
    public void getDetailTest(){
        long boardBno = 3L;
        boardMapper.getDetail(boardBno);
    }

    // 게시글 삭제
    @Test
    public void delTest(){
        long boardBno = 2L;
        boardMapper.del(boardBno);
    }

    // 게시글 수정
    @Test
    public void updateTest(){
        // 입력받은 보드번호
        Long boardBno = 2L;
        // 해당 보드의 정보 불러오기
        BoardVO boardVO = boardMapper.getDetail(boardBno);
        // 보드가 존재하지 않으면 종료 ... 불필요한 연산을 줄여줌
        if(boardVO == null){log.info("no board"); return;}
        // 수정내용
        boardVO.setBoardTitle("Test");
        boardVO.setBoardContent("Test");
        // 수정
        boardMapper.update(boardVO);
    }

}
