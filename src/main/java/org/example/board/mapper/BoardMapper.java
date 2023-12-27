package org.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.board.entity.BoardVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    // 게시글 목록
    List<Map<String, Object>> getBoardList();

    // 게시글 상세보기
    BoardVO getBoardDetail(int id);

    // 게시글 등록
    int insertBoard(BoardVO boardVO);

//    // 게시글 수정
//    int updateBoard(BoardVO boardVO);
//
//    // 게시글 삭제
//    int deleteBoard(BoardVO boardVO);
}
