package com.ga.capitalmgmtplatform.service.impl;

import com.ga.capitalmgmtplatform.mapper.AccountDetailDao;
import com.ga.capitalmgmtplatform.pojo.AccountBalanceInfo;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import com.ga.capitalmgmtplatform.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailServiceImpl implements AccountDetailService{
    @Autowired
    private AccountDetailDao detailDao;

    @Override
    public int add(List<AccountDetail> list){
        return detailDao.add(list);
    }

    @Override
    public List<AccountDetail> getDetailsByDateAndAccnum(String date, String accNum) {
        List<AccountDetail> list;
        if(date==""){
            list = detailDao.getLastDetailsByAccnum(accNum);
        }else {
            list = detailDao.getDetailsByDateAndAccnum(date, accNum);
        }
        return list;
    }

    @Override
    public List<AccountDetail> getDetailsByDatesAndAccnum(String dtFrom, String dtTo, String accNum) {
        List<AccountDetail> list = detailDao.getDetailsByDatesAndAccnum(dtFrom, dtTo, accNum);
        return list;
    }

    @Override
    public List<AccountBalanceInfo> getBalanceDetailsByUserId(Long id) {
        List<AccountBalanceInfo> list = detailDao.getBalanceDetailsByUserId(id);
        return list;
    }
}
