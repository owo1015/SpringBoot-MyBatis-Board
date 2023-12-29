package org.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/postUpload")
    public String postUpload() {
        return "postUpload";
    }

    @GetMapping("/postModify")
    public String postModify() {
        return "postModify";
    }
}