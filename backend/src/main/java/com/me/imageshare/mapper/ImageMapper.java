package com.me.imageshare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.imageshare.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ImageMapper  extends BaseMapper<Image> {

}
