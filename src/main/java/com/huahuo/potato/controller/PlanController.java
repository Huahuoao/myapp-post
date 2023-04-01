package com.huahuo.potato.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huahuo.potato.common.ResponseResult;
import com.huahuo.potato.dto.PlanDto;
import com.huahuo.potato.pojo.Plan;
import com.huahuo.potato.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @作者 花火
 * @创建日期 2023/4/1 11:58
 */
@RestController
@CrossOrigin
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody PlanDto planDto) {
        LambdaQueryWrapper<Plan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Plan::getUserId, planDto.getUserId());
        queryWrapper.eq(Plan::getCreateTime, planDto.getDate());
        List<Plan> list = planService.list(queryWrapper);
        return ResponseResult.okResult(list);
    }


    @PostMapping("/add")
    public ResponseResult add(@RequestBody PlanDto planDto) {
        Plan plan = new Plan();
        plan.setText(planDto.getText());
        plan.setUserId(planDto.getUserId());
        plan.setCreateTime(DateUtil.today());
        planService.save(plan);
        return ResponseResult.okResult("添加成功");
    }
}
