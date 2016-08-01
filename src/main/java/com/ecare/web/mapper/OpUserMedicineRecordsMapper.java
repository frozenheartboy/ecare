package com.ecare.web.mapper;

import com.ecare.web.pojo.OpUserMedicineRecords;

import java.util.Date;
import java.util.List;

public interface OpUserMedicineRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpUserMedicineRecords record);

    int insertSelective(OpUserMedicineRecords record);

    OpUserMedicineRecords selectByPrimaryKey(Integer id);

    List<OpUserMedicineRecords> selectRemind(String date);

    int updateByPrimaryKeySelective(OpUserMedicineRecords record);

    int updateByPrimaryKey(OpUserMedicineRecords record);
}