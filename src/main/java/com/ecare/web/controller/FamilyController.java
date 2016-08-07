package com.ecare.web.controller;

import com.ecare.web.pojo.Relations;
import com.ecare.web.service.FamilyService;
import com.ecare.web.util.ResultUtil;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李鹏飞 lipengfei19927@163.com
 * @datetime 2016-8-3 10:36:16
 */
@Controller
@RequestMapping("/Family")
@ResponseBody
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @RequestMapping("/getDirectRelations")
    public Map<String, Object> getDirectRelations(@RequestParam(value = "userId") Integer userId) {
        List<Integer> directRelationsIds = familyService.myDirectRelationIds(userId);
        List<Integer> myRelationIds = familyService.myRelationIds(userId);
        return ResultUtil.getResult(200, "200", myRelationIds);
    }

}
