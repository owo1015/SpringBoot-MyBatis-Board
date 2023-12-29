package org.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.board.entity.UserVO;

@Mapper
public interface UserMapper {

    // 로그인
    UserVO getUserInfo(String id);

    // 회원가입
    int saveUserInfo(UserVO userVO);
}
