package cn.kgc.demo.demo.service.impl;

import cn.kgc.demo.demo.entity.User;
import cn.kgc.demo.demo.mapper.UserMapper;
import cn.kgc.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserSericeImpl implements UserService {
@Autowired
private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public boolean verify(String userCode, String userPassword) {
      boolean result= false;
      //
        User user= userMapper.selectByUserName(userCode);
        if(user==null){
            throw new RuntimeException(userCode+"木有");

        }else{
            result=user.getUserpassword().equals(userPassword);
        }
        return  result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED )
    public void register(User user) {
this.userMapper.insert(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchAll() {
        return this.userMapper.selectByExample(null);
    }
}
