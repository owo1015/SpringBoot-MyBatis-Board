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

    @GetMapping("/{id}")
    public ResponseEntity<BoardVO> boardDetail(@PathVariable int id) {
        return ResponseEntity.ok(this.boardService.getBoardDetail(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(BoardVO boardVO, @AuthenticationPrincipal UserVO userVO) {
        return ResponseEntity.ok(this.boardService.insertBoard(boardVO, userVO));
    }

//    @PutMapping("/{id}/update")
//    public ResponseEntity<Integer> updateBoard(BoardVO boardVO, @PathVariable int id) {
//        return ResponseEntity.ok(this.boardService.updateBoard(boardVO, id));
//    }
//
//    @DeleteMapping("/{id}/delete")
//    public ResponseEntity<Integer> deleteBoard(BoardVO boardVO, @PathVariable int id) {
//        return ResponseEntity.ok(this.boardService.deleteBoard(boardVO, id));
//    }
}