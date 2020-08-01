package com.example.service.serviceImpl;

import com.example.dao.UserDao;
import com.example.entity.UserLoginLog;
import com.example.entity.Users;
import com.example.service.UserLoginLogService;
import com.example.service.UserService;
import com.example.utils.MD5Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Resource
    private UserLoginLogService userLoginLogService;

    /**
     * 注册
     *
     * @param users
     */
    @Override
    public void save(Users users) {
        Date notTime = new Date();
        users.setCreate_time(notTime);
        users.setState(1);
        users.setSalt(RandomStringUtils.randomAlphanumeric(16));
        String generate = MD5Utils.generate(users.getPassword(), users.getSalt());
        users.setPassword(generate);
        userDao.save(users);
    }

    /**
     * 登录
     *
     * @param users
     * @return
     */
    @Override
    public Map<String, String> login(Users users) {
        HashMap<String, String> map = new HashMap<>();
        List<Users> usersList = userDao.findByName(users.getName());
        if (usersList != null && usersList.size() > 0) {
            for (Users user : usersList) {
                String generate = MD5Utils.generate(users.getPassword(), user.getSalt());
                if (generate.equals(user.getPassword())) {
                    UserLoginLog log = new UserLoginLog();
                    log.setLogin_time(new Date());
                    log.setUser_id(user.getId());
                    try {
                        log.setLogin_ip(InetAddress.getLocalHost().getHostAddress());
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    userLoginLogService.save(log);
                    map.put("msg", "登录成功");
                    map.put("resultCode", "200");
                    return map;
                }
                map.put("msg", "密码错误");
                map.put("resultCode", "203");
                return map;
            }


        }
        map.put("msg", "该用户不存在");
        map.put("resultCode", "203");
        return map;
    }
}
