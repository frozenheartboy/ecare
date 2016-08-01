package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.OpUserMedicineRecordsMapper;
import com.ecare.web.pojo.OpUserMedicineRecords;
import com.ecare.web.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2016/8/1.
 */
@Service
public class RemindServiceImpl implements RemindService{
    @Autowired
    OpUserMedicineRecordsMapper opUserMedicineRecordsMapper;

    public List<OpUserMedicineRecords> findOpRemind(String date) {
        return opUserMedicineRecordsMapper.selectRemind(date);
    }


}
