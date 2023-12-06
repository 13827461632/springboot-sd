package com.min.service.imp;

import com.min.comm.dto.User;
import com.min.dao.dataobject.UserDO;
import com.min.dao.mapper.UserMapper;
import com.min.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper  userMapper;
    @Override
    public void createUser(String name) {
        userMapper.insertUser(name);

    }
    @Override
    public UserDO queryUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<User> queryAll() {
        List<UserDO> userList = userMapper.findAll();
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.stream()
                .map(u -> new User(u.getName(), u.getAge()))
                .collect(Collectors.toList());
    }
}
