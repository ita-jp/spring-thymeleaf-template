package com.example.app.repository.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
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
    Optional<UserRecord> selectByUsername(String username);

    @Insert("""
            INSERT INTO users (username, password, enabled)
            VALUES (#{username}, #{password}, #{enabled})
            """)
    void insert(String username, String password, boolean enabled);

    @Select("""
            SELECT
                u.authority
            FROM authorities u
            WHERE u.user_id = #{userId}
            """)
    List<String> selectAuthoritiesByUserId(long userId);

    @Insert("""
            INSERT INTO authorities (user_id, authority)
            VALUES (#{userId}, #{authority})
            """)
    void insertAuthorities(long userId, String authority);
}
