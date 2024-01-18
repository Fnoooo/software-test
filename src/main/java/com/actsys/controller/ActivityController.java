package com.actsys.controller;

import com.actsys.vo.*;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/13 9:01
 */

@Controller
@RequestMapping("/activities")
public class ActivityController {
    @GetMapping("/list")
    public String list(Model model) {
        // 准备数据: categories,
        model.addAttribute("categories",
                CategoryVO.categoryVOList());

        return "backend/activity/list" ;
    }
    @PostMapping("/list")
    @ResponseBody
    public PageResultVO queryActivities(ActivityConditionVO activityConditionVO) {
        List<ActivityVO> activityVOList = ActivityVO.ACTIVITY_VOS;
        return new PageResultVO(activityVOList,
                             activityVOList.size()) ;
    }
    @PostMapping("/publish")
    @ResponseBody
    public ResponseResult publishActivity(String id){
//        log.info("publish activity:{}",actId);
        ActivityVO.updateActivityVO(
                ActivityVO.findActivityVO(Integer.parseInt(id)));
        return ResponseResult.success("操作成功");

    }

}
