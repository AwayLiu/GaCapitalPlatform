package com.ga.capitalmgmtplatform.service.impl;

import com.ga.capitalmgmtplatform.mapper.AccountInfoDao;
import com.ga.capitalmgmtplatform.pojo.AccountInfo;
import com.ga.capitalmgmtplatform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountInfoDao accountDao;

    public List<AccountInfo> GetAccountInfoByCode(String code) {
        List<AccountInfo> result = accountDao.getByCode(code);
        return result;
    }

    @Override
    public List<AccountInfo> GetAccountInfoById(Long userid) {
        List<AccountInfo> result = accountDao.getById(userid);
        return result;
    }
}
