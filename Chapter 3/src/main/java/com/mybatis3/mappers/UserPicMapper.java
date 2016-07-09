package com.mybatis3.mappers;

import com.mybatis3.domain.UserPic;

/**
 * Created by vonzhou on 16/7/9.
 */
public interface UserPicMapper {
    public void insertUserPic(UserPic pic);
    public UserPic getUserPic(int id);
}
