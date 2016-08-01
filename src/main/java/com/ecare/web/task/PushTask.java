package com.ecare.web.task;

import com.ecare.web.mapper.OpUserMedicineRecordsMapper;
import com.ecare.web.pojo.OpUserMedicineRecords;
import com.ecare.web.util.JpushUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by L on 2016/8/1.
 */
@Component
public class PushTask {
    @Autowired
    OpUserMedicineRecordsMapper opUserMedicineRecordsMapper;

    @Scheduled(cron = "0 0 0 * * *")
    public void outUpdate() {

    }
    @Scheduled(cron = "0 * * * * *")
    public void medicinePush() {
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, +1);
        date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        List<OpUserMedicineRecords> opUserMedicineRecordsList=opUserMedicineRecordsMapper.selectRemind(sdf.format(date));
        for(OpUserMedicineRecords opUserMedicineRecords:opUserMedicineRecordsList){
            JpushUtil.sendPushMessage(opUserMedicineRecords.getUserId().toString(),
                    "该吃药了 "+opUserMedicineRecords.getRecordName()+" "+
                            opUserMedicineRecords.getTakingWays()+" "+
                            opUserMedicineRecords.getTakingFrequency());
        }


    }
}
