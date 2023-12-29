package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.entity.UserVO;
import org.example.board.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public int signup(@RequestBody UserVO userVO) {
        return this.userService.saveUser(userVO);
    }
}
