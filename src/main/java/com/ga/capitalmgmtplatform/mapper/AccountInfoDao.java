package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.AccountInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AccountInfoDao {
    int add(AccountInfo user);

    void delete(int id);

    AccountInfo get(int id);

    int update(AccountInfo user);

    List<AccountInfo> list();

    List<AccountInfo> getByCode(String code);

    List<AccountInfo> getById(@Param("id") Long id);
}
