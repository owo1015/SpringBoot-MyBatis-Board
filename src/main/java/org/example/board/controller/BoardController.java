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

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/post")
    public String post() {
        return "post";
    }
}