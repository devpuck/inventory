package com.wms.model.bo.inventory;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 盘点明细表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
public class InventoryWarehouseBillSubBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    private Long id;

    /**
     * 台账ID
     */
    private String accountId;

    /**
     * 单据编号
     */
    private String billCode;

    /**
     * 编号数量
     */
    private BigDecimal changeQuantity;

    /**
     * 盘盈、盘亏
     */
    private String changeType;

    /**
     * 盘点人
     */
    private String inventoryPerson;

    /**
     * 盘点时间
     */
    private Date inventoryTime;

}
