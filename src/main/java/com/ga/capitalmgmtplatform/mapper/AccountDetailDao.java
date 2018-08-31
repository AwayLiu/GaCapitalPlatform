package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.AccountBalanceInfo;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountDetailDao {

    int add(List<AccountDetail> details);

    List<AccountDetail> getDetailsByDateAndAccnum(@Param("date")String date, @Param("accNum")String accNum);

    List<AccountDetail> getLastDetailsByAccnum(@Param("accNum")String accNum);

    List<AccountDetail> getDetailsByDatesAndAccnum(@Param("dtFrom") String dtFrom, @Param("dtTo") String dtTo, @Param("accNum") String accNum);

    List<AccountBalanceInfo> getBalanceDetailsByUserId(@Param("id") Long id);

    AccountDetail getLastDetailByAccnum(@Param("accNum") String accNum);
}
