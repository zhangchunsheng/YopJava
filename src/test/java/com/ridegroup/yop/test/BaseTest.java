package com.ridegroup.yop.test;

import com.ridegroup.yop.api.BaseAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected final static String ACCESS_TOKEN = "AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3";

    protected final static String CITY = "bj";
    protected final static String TYPE = "17";
    protected final static String CAR_TYPE_ID = "2";

    public static Map<String, Object> getEstimatedParams(boolean hasCarType) {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * 'city'=>'bj',
            'type' => 7,
            'aircode'=>'PEK', //接送机必填
            'car_type_id' => 2,
            'expect_start_latitude' => '39.955538',
            'expect_start_longitude' => '116.458637',
            'expect_end_latitude' => '39.911093',
            'expect_end_longitude' => '116.373055',
            'time' => '2013-04-19 11:22:33',
            'rent_time' => 2,
            'map_type' => 2
         */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY) + 10);
        long time = System.currentTimeMillis();

        reqMap.put("city", "bj");
        reqMap.put("type", "7");
        reqMap.put("aircode", "PEK");
        if(hasCarType) {
            reqMap.put("car_type_id", "2");
        }
        reqMap.put("start_position", "颐和园");
        reqMap.put("expect_start_latitude", "39.955538");
        reqMap.put("expect_start_longitude", "116.458637");
        reqMap.put("time", df.format(calendar.getTime()));
        reqMap.put("rent_time", "2");
        reqMap.put("end_position", "总部基地");
        reqMap.put("expect_end_latitude", "39.911093");
        reqMap.put("expect_end_longitude", "116.373055");
        reqMap.put("map_type", BaseAPI.MAP_TYPE_MARS);

        return reqMap;
    }
}
