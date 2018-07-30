package com.ga.capitalmgmtplatform.service.impl;

import com.ga.capitalmgmtplatform.mapper.AccountInfoDao;
import com.ga.capitalmgmtplatform.pojo.AccountInfo;
import com.ga.capitalmgmtplatform.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private AccountInfoDao accDao;

    public List<AccountInfo> getAccountInfoByDepartCode(){
        return null;
    }
}
