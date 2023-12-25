package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @GetMapping("api/board/list")
    public ResponseEntity<List<Map<String, Object>>> boardList() {
        return ResponseEntity.ok(this.boardService.getBoardList());
    }
}