package com.min.service;

import com.min.comm.dto.User;
import com.min.dao.dataobject.UserDO;

import java.util.List;

public interface UserService {
    void createUser(String name);

    UserDO queryUserByName(String name);

    List<User> queryAll();
}
