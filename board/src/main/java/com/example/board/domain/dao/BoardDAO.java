package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    // 게시글 목록
    public List<BoardVO> getList(Criteria criteria){
        return  boardMapper.getList(criteria);
    };

    // 게시물 개수
    public int getTotal() {return boardMapper.getTotal();};

    // 게시글 등록
    public void register(BoardVO boardVO){
        boardMapper.insert(boardVO);
    };

    // 게시글 상세보기
    public BoardVO read(long boardBno){
        return  boardMapper.getDetail(boardBno);
    };

    // 게시글 삭제
    public boolean remove(long boardBno){
        return  boardMapper.del(boardBno) != 0;
    };

    // 게시글 수정
    public boolean modify(BoardVO boardVO){
        return  boardMapper.update(boardVO) != 0;
    };
}
