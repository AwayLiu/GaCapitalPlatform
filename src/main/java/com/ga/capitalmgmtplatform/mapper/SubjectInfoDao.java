package com.ga.capitalmgmtplatform.mapper;

import com.ga.capitalmgmtplatform.pojo.SubjectInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectInfoDao {
    int add(SubjectInfo user);

    void delete(int id);

    SubjectInfo get(int id);

    int update(SubjectInfo user);

    List<SubjectInfo> list();

    int count();
}
