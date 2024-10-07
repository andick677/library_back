package org.example.library.Dao;

import org.example.library.Dto.UserRequest;
import org.example.library.Model.User;
import org.example.library.Rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.security.spec.NamedParameterSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public User getUser(UserRequest userRequest){
        String sql = "Select id,username,password FROM library.user WHERE username = :username AND password = :password";

        Map<String, Object> map = new HashMap<>();
        map.put("username",userRequest.getUsername());
        map.put("password",userRequest.getPassword());

        List<User> userList = namedParameterJdbcTemplate.query(sql,map,new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public User getUserId(int id){
        String sql = "Select id,username,password FROM library.user WHERE id = :id";

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        List<User> userList = namedParameterJdbcTemplate.query(sql,map,new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public int createUser(UserRequest userRequest){
        String sql = "INSERT INTO library.user(username, password) VALUES (:username, :password)";

        Map<String, Object> map = new HashMap<>();
        map.put("username",userRequest.getUsername());
        map.put("password", userRequest.getPassword());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int bookId = keyHolder.getKey().intValue();

        return bookId;
    }
}
