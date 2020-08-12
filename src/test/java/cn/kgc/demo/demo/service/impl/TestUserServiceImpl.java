package cn.kgc.demo.demo.service.impl;

import cn.kgc.demo.demo.DemoApplication;
import cn.kgc.demo.demo.entity.User;
import cn.kgc.demo.demo.mapper.UserMapper;
import cn.kgc.demo.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemoApplication.class)
public class TestUserServiceImpl {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
public void testVerfy(){

    String userName="系统管理员";
    String userPassword="1234567";
    boolean result=true;
    result=userService.verify(userName,userPassword);
    Assert.assertTrue(result);
}

@Test
    public void testRogister()throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1986-10-14");
    User user =new User();
    user.setUsercode("asd");
    user.setUsername("张");
    user.setGender(1);
    user.setBirthday(date);
    user.setPhone("13131");
    user.setAddress("444");
 user.setCreatedby(4554456l);
user.setUserrole(1);
user.setCreatedby(1l);
user.setCreationdate(date);



 this.userService.register(user);
 user=userMapper.selectByUserName("张");

Assert.assertNotNull(user);

    }
    @Test
    public void testSearchAll(){
List<User> userList=this.userService.searchAll();
int size=userList.size();
boolean b=size>13 ;
Assert.assertTrue(b);
    }



}
