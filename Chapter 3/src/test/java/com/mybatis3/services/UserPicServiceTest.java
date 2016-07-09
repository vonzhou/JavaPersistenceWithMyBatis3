package com.mybatis3.services;

import com.mybatis3.domain.Student;
import com.mybatis3.domain.UserPic;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vonzhou on 16/7/9.
 */
public class UserPicServiceTest {
    private static UserPicService userPicService;

    @BeforeClass
    public static void setup() {
        userPicService = new UserPicService();
        //TestDataPopulator.initDatabase();
    }

    @AfterClass
    public static void teardown() {
        userPicService = null;
    }

    //@Test
    public void testAddPic() {
        byte[] pic = null;
        try {
            File file = new File("/Users/vonzhou/Downloads/6712339.jpeg");
            InputStream is = new FileInputStream(file);
            pic = new byte[is.available()];
            is.read(pic);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = "UserName";
        String bio = "put some lenghty bio here";
        UserPic userPic = new UserPic(0, name, pic, bio);
        userPicService.addUserPic(userPic);
    }

    @Test
    public void testGetUserPic() {
        UserPic userPic = userPicService.getUserPic(1);
        byte[] pic = userPic.getPic();
        try {
            OutputStream os = new FileOutputStream(new
                    File("/Users/vonzhou/Downloads/new.jpeg"));
            os.write(pic);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
