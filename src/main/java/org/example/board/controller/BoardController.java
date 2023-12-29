package org.example.board.controller;

import org.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/postUpload")
    public String postUpload() {
        return "postUpload";
    }

    @GetMapping("/postModify/{id}")
    public String postModify(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.getBoardDetail(id));
        return "postModify";
    }
}