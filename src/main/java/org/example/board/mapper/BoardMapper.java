package org.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.board.entity.BoardVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    // 게시글 목록
    List<Map<String, Object>> getBoardList();

    // 게시글 등록
    void insertBoard(BoardVO boardVO);
}
