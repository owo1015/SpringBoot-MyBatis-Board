package org.example.board.service;

import org.example.board.entity.BoardVO;
import org.example.board.entity.UserVO;
import org.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 게시글 목록
    public List<Map<String, Object>> getBoardList() {
        return this.boardMapper.getBoardList();
    }

    // 게시글 상세보기
    public BoardVO getBoardDetail(int id) {
        return this.boardMapper.getBoardDetail(id);
    }

    // 게시글 등록
    public int insertBoard(BoardVO boardVO) {
        return this.boardMapper.insertBoard(boardVO);
    }

    // 게시글 수정
    public int updateBoard(BoardVO boardVO) {
        return this.boardMapper.updateBoard(boardVO);
    }

    // 게시글 삭제
    public int deleteBoard(BoardVO boardVO) {
        return this.boardMapper.deleteBoard(boardVO);
    }
}
