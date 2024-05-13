package com.example.app.repository.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT
                u.id
              , u.username
              , u.password
              , u.enabled
            FROM users u
            WHERE u.username = #{username}
            """)
    Optional<UserRecord> findByUsername(String username);
    
    @Insert("""
            INSERT INTO users (username, password, enabled)
            VALUES (#{username}, #{password}, #{enabled})
            """)
    void insert(String username, String password, boolean enabled);
}
