package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.AccountBalanceInfo;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountDetailService {

    int add(List<AccountDetail> list);

    AccountDetail getLastDetailByAccnum(@Param("accNum") String accNum);

    List<AccountDetail> getDetailsByDateAndAccnum(@Param("date") String date, @Param("accNum") String accNum);

    List<AccountDetail> getDetailsByDatesAndAccnum(@Param("dtFrom") String dtFrom, @Param("dtTo") String dtTo, @Param("accNum") String accNum);

    List<AccountBalanceInfo> getBalanceDetailsByUserId(@Param("id") Long id);
}
