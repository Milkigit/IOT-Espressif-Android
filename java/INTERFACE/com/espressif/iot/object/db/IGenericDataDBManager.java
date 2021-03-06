package com.espressif.iot.object.db;

import java.util.List;

import com.espressif.iot.db.greenrobot.daos.GenericDataDB;
import com.espressif.iot.object.IEspDBManager;

public interface IGenericDataDBManager extends IEspDBManager
{
    /**
     * @param deviceId device id
     * @param startTimestamp UTC timestamp of start
     * @param endTimestamp UTC timestamp of end
     * @return the @see GenericDataDB list or Empty list
     */
    List<GenericDataDB> getDataList(long deviceId, long startTimestamp, long endTimestamp);
    
    /**
     * 
     * @param deviceId device id
     * @param startTimestampUTCDay start timestamp and it should be the 00:00:00 at UTC time
     * @param endTimestampUTCDay end timestamp and it should be the 00:00:00 at UTC time
     */
    void updateDataDirectoryLastAccessedTime(long deviceId, long startTimestampUTCDay, long endTimestampUTCDay);
    
    /**
     * insert or replace the data list into db
     * 
     * @param startTimestampUTCDay start timestamp and it should be the 00:00:00 at UTC time
     * @param endTimestampUTCDay end timestamp and it should be the 00:00:00 at UTC time
     * @param dataDBList the data list to be inserted(!NOTE: timestamp of dataList should be ascending)
     */
    void insertOrReplaceDataList(List<GenericDataDB> dataDBList, long startTimestampUTCDay, long endTimestampUTCDay);
    
    /**
     * 
     * @return how many data stored in local db totally now
     */
    long __getDataTotalCount();
    
    /**
     * delete the data list
     * 
     * @param dataDBList the data list to be inserted
     */
    void __deleteDataList(List<GenericDataDB> dataDBList);
}
