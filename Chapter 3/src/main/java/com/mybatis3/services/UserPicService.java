package com.mybatis3.services;

import com.mybatis3.domain.UserPic;
import com.mybatis3.mappers.UserPicMapper;
import com.mybatis3.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.*;

/**
 * Created by vonzhou on 16/7/9.
 */
public class UserPicService {

    public void addUserPic(UserPic userPic) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserPicMapper mapper =
                    sqlSession.getMapper(UserPicMapper.class);
            mapper.insertUserPic(userPic);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public UserPic getUserPic(int id) {
        UserPic userPic = null;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserPicMapper mapper =
                    sqlSession.getMapper(UserPicMapper.class);
            userPic = mapper.getUserPic(1);
        } finally {
            sqlSession.close();
        }

        return userPic;

    }
}