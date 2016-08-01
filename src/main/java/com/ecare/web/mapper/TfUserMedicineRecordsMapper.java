package com.ecare.web.mapper;

import com.ecare.web.pojo.TfUserMedicineRecords;

public interface TfUserMedicineRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TfUserMedicineRecords record);

    int insertSelective(TfUserMedicineRecords record);

    TfUserMedicineRecords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TfUserMedicineRecords record);

    int updateByPrimaryKey(TfUserMedicineRecords record);
}