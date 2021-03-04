package com.wms.model.bo.inventory;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 盘点表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
public class InventoryWarehouseBillBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    private Long id;

    /**
     * 单据编号
     */
    private String billCode;

    /**
     * 库房编号
     */
    private String warehouseCode;

    /**
     * 事务编号
     */
    private String workCode;

    /**
     * 盘点类型
     */
    private String inventoryType;

    /**
     * 状态
     */
    private String status;

    private String version;

    /**
     * 备注
     */
    private String note;

    /**
     * 盘点子单
     */
    List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList;
}
