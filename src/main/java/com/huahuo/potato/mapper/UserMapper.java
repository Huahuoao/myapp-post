package com.huahuo.potato.mapper;

import com.huahuo.potato.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-03-29 11:39:05
* @Entity com.huahuo.potato.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




