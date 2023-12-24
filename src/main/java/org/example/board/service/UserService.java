package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.entity.UserVO;
import org.example.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // 로그인
    @Override
    public UserVO loadUserByUsername(String id) throws UsernameNotFoundException {
        UserVO userVO = userMapper.getUserInfo(id);
        if(userVO == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return userVO;
    }

    // 회원가입
    public void saveUser(UserVO userVO) {
        userVO.setPassword(encoder.encode(userVO.getPassword()));
        userMapper.saveUserInfo(userVO);
    }
}
