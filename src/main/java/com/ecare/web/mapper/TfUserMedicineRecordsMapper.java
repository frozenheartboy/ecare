package com.ecare.web.mapper;

import com.ecare.web.pojo.TfUserMedicineRecords;

import java.util.List;

public interface TfUserMedicineRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TfUserMedicineRecords record);

    int insertSelective(TfUserMedicineRecords record);

    TfUserMedicineRecords selectByPrimaryKey(Integer id);

    List<TfUserMedicineRecords> selectInTime();

    List<TfUserMedicineRecords> selectRemind(String date);

    int updateByPrimaryKeySelective(TfUserMedicineRecords record);

    int updateByPrimaryKey(TfUserMedicineRecords record);

    int updateOutTimeByPrimaryKey(Integer id);
}