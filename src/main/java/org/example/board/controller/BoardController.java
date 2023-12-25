package org.example.board.controller;

import org.example.board.entity.BoardVO;
import org.example.board.entity.UserVO;
import org.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/post")
    public String post() {
        return "post";
    }

    @PostMapping("/api/board/insert")
    public String insert(BoardVO boardVO, @AuthenticationPrincipal UserVO userVO) {
        boardService.insertBoard(boardVO, userVO);
        return "redirect:/";
    }
}