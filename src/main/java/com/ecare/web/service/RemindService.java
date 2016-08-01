package com.ecare.web.service;

import com.ecare.web.pojo.OpUserMedicineRecords;

import java.util.List;

/**
 * Created by L on 2016/8/1.
 */
public interface RemindService {

    List<OpUserMedicineRecords> findOpRemind(String date);
}
