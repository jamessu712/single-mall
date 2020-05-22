package com.jamessu712.mall.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BaseModel
 * @Description TODO
 * @Author jamessu
 * @Date 20/05/2020 3:16 PM
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseModel {

    private int pk;
    private long creationTime;
    private long modifiedTime;

}
