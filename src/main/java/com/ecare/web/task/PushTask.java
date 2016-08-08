package com.ecare.web.task;

import com.ecare.web.mapper.OpUserMedicineRecordsMapper;
import com.ecare.web.mapper.TfUserMedicineRecordsMapper;
import com.ecare.web.mapper.UsersMapper;
import com.ecare.web.pojo.OpUserMedicineRecords;
import com.ecare.web.pojo.TfUserMedicineRecords;
import com.ecare.web.service.FamilyService;
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
    @Autowired
    TfUserMedicineRecordsMapper tfUserMedicineRecordsMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    private FamilyService familyService;

    @Scheduled(cron = "0 0 0 * * *")
    public void outUpdate() {
        Date now = new Date();
        Calendar calendarDate = Calendar.getInstance();

        List<OpUserMedicineRecords> opUserMedicineRecordsList = opUserMedicineRecordsMapper.selectInTime();
        for (OpUserMedicineRecords opUserMedicineRecords : opUserMedicineRecordsList) {

            calendarDate.setTime(opUserMedicineRecords.getStartTime());
            calendarDate.add(Calendar.DATE, +opUserMedicineRecords.getTreatmentPeriod() - 1);
            Date date = calendarDate.getTime();
            //如果过期更新is_out_time字段
            if (date.before(now)) {
                opUserMedicineRecordsMapper.updateOutTimeByPrimaryKey(opUserMedicineRecords.getId());
            }

        }
        List<TfUserMedicineRecords> tfUserMedicineRecordsList = tfUserMedicineRecordsMapper.selectInTime();
        for (TfUserMedicineRecords tfUserMedicineRecords : tfUserMedicineRecordsList) {
            calendarDate.setTime(tfUserMedicineRecords.getStartTime());
            calendarDate.add(Calendar.DATE, +tfUserMedicineRecords.getTreatmentPeriod() - 1);
            Date date = calendarDate.getTime();
            if (date.before(now)) {
                tfUserMedicineRecordsMapper.updateOutTimeByPrimaryKey(tfUserMedicineRecords.getId());
            }

        }

    }

    /**
     * 疗程还有一天过期，推送给家人
     */
    @Scheduled(cron = "0 0 19 * * *")
    public void outTimePush() {
        Date now = new Date();
        Calendar calendarDate = Calendar.getInstance();
        List<Integer> myDirectRelationIds;
        List<Integer> myRelationIds;

        List<OpUserMedicineRecords> opUserMedicineRecordsList = opUserMedicineRecordsMapper.selectInTime();
        for (OpUserMedicineRecords opUserMedicineRecords : opUserMedicineRecordsList) {
            calendarDate.setTime(opUserMedicineRecords.getStartTime());
            calendarDate.add(Calendar.DATE, +opUserMedicineRecords.getTreatmentPeriod() - 2);//获取药物结束得前一天
            Date date = calendarDate.getTime();
            //如果还差一天过期
            if (date.before(now)) {
                myDirectRelationIds = familyService.myDirectRelationIds(opUserMedicineRecords.getUserId());
                myRelationIds = familyService.myRelationIds(opUserMedicineRecords.getUserId());
                myRelationIds.removeAll(myDirectRelationIds);
                myRelationIds.addAll(myDirectRelationIds);

                String name = usersMapper.selectByPrimaryKey(opUserMedicineRecords.getUserId()).getName();
                for (int i = 0; i < myRelationIds.size(); i++) {
                    String get = myRelationIds.get(i).toString();
                    JpushUtil.sendPushMessage(get,
                            name + "药物即将过期，记得提醒他不要忘记哦");

                }
            }

        }
        List<TfUserMedicineRecords> tfUserMedicineRecordsList = tfUserMedicineRecordsMapper.selectInTime();
        for (TfUserMedicineRecords tfUserMedicineRecords : tfUserMedicineRecordsList) {
            calendarDate.setTime(tfUserMedicineRecords.getStartTime());
            calendarDate.add(Calendar.DATE, +tfUserMedicineRecords.getTreatmentPeriod() - 2);
            Date date = calendarDate.getTime();
            if (date.before(now)) {
                myRelationIds = familyService.myRelationIds(tfUserMedicineRecords.getUserId());
                myDirectRelationIds = familyService.myDirectRelationIds(tfUserMedicineRecords.getUserId());
                myRelationIds.removeAll(myDirectRelationIds);
                myRelationIds.addAll(myDirectRelationIds);

                String name = usersMapper.selectByPrimaryKey(tfUserMedicineRecords.getUserId()).getName();
                for (int i = 0; i < myRelationIds.size(); i++) {
                    String get = myRelationIds.get(i).toString();
                    JpushUtil.sendPushMessage(get,
                            name + "药物即将过期，记得提醒他不要忘记哦");

                }

            }

        }
    }
    @Scheduled(cron = "0 * * * * *")
    public void medicinePush() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, +1);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(date);

        //查询到该提醒的给对应用于和家人提醒
        List<OpUserMedicineRecords> opUserMedicineRecordsList = opUserMedicineRecordsMapper.selectRemind(time);
        for (OpUserMedicineRecords opUserMedicineRecords : opUserMedicineRecordsList) {
            List<Integer> myDirectRelationIds = familyService.myDirectRelationIds(opUserMedicineRecords.getUserId());
            List<Integer> myRelationIds = familyService.myRelationIds(opUserMedicineRecords.getUserId());
            myRelationIds.removeAll(myDirectRelationIds);
            myRelationIds.addAll(myDirectRelationIds);
            /**
             * myRelationIds 为 我关联的所有非傀儡用户id 获取我的用户名 给这些人发送消息
             */
            String name = usersMapper.selectByPrimaryKey(opUserMedicineRecords.getUserId()).getName();
            for (int i = 0; i < myRelationIds.size(); i++) {
                String get = myRelationIds.get(i).toString();
                JpushUtil.sendPushMessage(get,
                        name + "到了服药时间，记得提醒他不要忘记哦");

            }
            /**
             * 给自己发送吃药通知/**
             */
            JpushUtil.sendPushNotice(opUserMedicineRecords.getUserId().toString(), null, "hello", "ALERT", opUserMedicineRecords.getRecordName());

        }
        List<TfUserMedicineRecords> tfUserMedicineRecordsList = tfUserMedicineRecordsMapper.selectRemind(time);
        for (TfUserMedicineRecords tfUserMedicineRecords : tfUserMedicineRecordsList) {
            JpushUtil.sendPushMessage(tfUserMedicineRecords.getUserId().toString(),
                    "该吃药了 " + tfUserMedicineRecords.getRecordName() + " "
                    + tfUserMedicineRecords.getTakingWays() + " "
                    + tfUserMedicineRecords.getTakingFrequency());
            JpushUtil.sendPushNotice(tfUserMedicineRecords.getUserId().toString(), null, "hello", "ALERT", tfUserMedicineRecords.getRecordName());

        }

    }

}
