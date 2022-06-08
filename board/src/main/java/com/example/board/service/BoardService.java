package com.example.board.service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public void register(BoardVO boardVO);
    public int getTotal();
    public BoardVO read(Long bno);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long bno);
    public List<BoardVO> getList(Criteria criteria);
}
