package com.yh.cloud.domain;

import lombok.Data;

/**
 * @author yh
 * @date 2020-11-02-10:34
 */
@Data

public class store {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
