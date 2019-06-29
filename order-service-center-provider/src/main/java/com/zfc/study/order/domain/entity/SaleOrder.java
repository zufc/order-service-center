package com.zfc.study.order.domain.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfc
 * @since 2019-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaleOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String orderId;

    private String orderName;

    private LocalDateTime createAt;


}
