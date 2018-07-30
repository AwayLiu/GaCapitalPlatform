package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.AccountInfo;

import java.util.List;

public interface AccountService {

    List<AccountInfo> GetAccountInfoByCode(String code);

    List<AccountInfo> GetAccountInfoById(Long userid);
}
