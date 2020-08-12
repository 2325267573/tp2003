package cn.kgc.demo.demo.mapper;

import cn.kgc.demo.demo.DemoApplication;
import cn.kgc.demo.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestUser {
    @Autowired
    private  UserMapper  userMapper;
    @Test
    public  void  testSelectByPrimaryKey(){
        long id =6;
        String userName="张华";
        String  userCode="zhanghua";
        User user=userMapper.selectByPrimaryKey(id);

String actuserName=user.getUsername();
String actuserCode=user.getUsercode();
        Assert.assertEquals(userName,actuserName);
        Assert.assertEquals(userCode,actuserCode);
    }
}
