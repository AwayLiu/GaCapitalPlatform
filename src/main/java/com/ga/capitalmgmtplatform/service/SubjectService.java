package com.ga.capitalmgmtplatform.service;

import com.ga.capitalmgmtplatform.pojo.AccountInfo;

import java.util.List;

public interface SubjectService {

    List<AccountInfo> getAccountInfoByDepartCode();
}
