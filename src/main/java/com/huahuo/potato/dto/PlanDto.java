package com.huahuo.potato.dto;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @作者 花火
 * @创建日期 2023/4/1 11:59
 */
@Data
public class PlanDto {
    Integer userId;
    String text;
    String date;
}
