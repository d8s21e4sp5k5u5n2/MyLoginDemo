package com.example.service.serviceImpl;

import com.example.dao.UserLoginLogDao;
import com.example.entity.UserLoginLog;
import com.example.service.UserLoginLogService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {

    @Resource
    private UserLoginLogDao userLoginLogDao;

    @Override
    public void save(UserLoginLog userLoginLog) {

        userLoginLogDao.save(userLoginLog);
    }

    @Override
    public List<UserLoginLog> loginLog() {
        return Lists.newArrayList(userLoginLogDao.findAll());
}


}
