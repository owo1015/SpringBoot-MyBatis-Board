package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.entity.BoardVO;
import org.example.board.entity.UserVO;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<List<Map<String, Object>>> boardList() {
        return ResponseEntity.ok(this.boardService.getBoardList());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<BoardVO> boardDetail(@PathVariable int id) {
        return ResponseEntity.ok(this.boardService.getBoardDetail(id));
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BoardVO boardVO, @AuthenticationPrincipal UserVO userVO) {
        boardVO.setUserId(userVO.getId());
        return this.boardService.insertBoard(boardVO);
    }

    @PostMapping("/update")
    public int update(@RequestBody BoardVO boardVO) {
        return this.boardService.updateBoard(boardVO);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody BoardVO boardVO) {
        return this.boardService.deleteBoard(boardVO);
    }
}