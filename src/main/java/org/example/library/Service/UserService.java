package org.example.library.Service;

import org.example.library.Dao.UserDao;
import org.example.library.Dto.UserRequest;
import org.example.library.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(UserRequest userRequest){
        return userDao.getUser(userRequest);
    }

    public User getUserId(int id){
        return userDao.getUserId(id);
    }

    public Integer createUser(UserRequest userRequest) {
        return userDao.createUser(userRequest);
    }
}
