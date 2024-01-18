package com.actsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/11/16 15:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityVO implements Serializable {
    private int actId ;
    private String name ;
    private String description ;
    private String title ;

    private String status ;
    // parsing date string to Date object
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // serializing or deserializing date object to json string
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime ;

    private CategoryVO category ;

    public static final String STATUS_PUBLISHED = "已发布";
    public static final String STATUS_UNPUBLISHED = "未发布";

    public static final List<ActivityVO> ACTIVITY_VOS ;

    static {
        ACTIVITY_VOS = activityVOList() ;
    }

    public ActivityVO(String name, String description, String title, Date startTime, Date endTime) {
        this.actId = new Random().nextInt(1000000000);
        this.name = name;
        this.description = description;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = STATUS_UNPUBLISHED;
        this.category = CategoryVO.categoryVOList().get(new Random().nextInt(CategoryVO.categoryVOList().size())) ;
    }

    public static ActivityVO findActivityVO(int actId) {
        return ACTIVITY_VOS.stream().filter(activityVO -> activityVO.getActId() == actId).findFirst().get();
    }

    public static void updateActivityVO(ActivityVO activityVO) {
//        ACTIVITY_VOS.remove(findActivityVO(activityVO.getActId()));
//        ACTIVITY_VOS.add(activityVO);
        activityVO.setStatus(STATUS_PUBLISHED);
    }

    public static List<ActivityVO> activityVOList() {
        List<ActivityVO> activityVOList = new ArrayList<>() ;
        ActivityVO activityVO1 = new ActivityVO("Activity 1", "This is activity 1",
                  "Activity 1", new Date(), new Date());
        ActivityVO activityVO2 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());

        ActivityVO activityVO3 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());

        ActivityVO activityVO4 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO5 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO6 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO7 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO8 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO9 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        ActivityVO activityVO10 = new ActivityVO("Activity 1", "This is activity 1", "Activity 1", new Date(), new Date());
        activityVOList.add(activityVO1);
        activityVOList.add(activityVO2);
        activityVOList.add(activityVO3);
        activityVOList.add(activityVO4);
        activityVOList.add(activityVO5);
        activityVOList.add(activityVO6);
        activityVOList.add(activityVO7);
        activityVOList.add(activityVO8);
        activityVOList.add(activityVO9);
        activityVOList.add(activityVO10);
        return activityVOList;

    }
}
