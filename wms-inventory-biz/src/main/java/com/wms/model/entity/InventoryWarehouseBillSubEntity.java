package com.wms.model.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.xac.core.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 盘点明细表
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_INVENTORY_WAREHOUSE_BILL_SUB")
public class InventoryWarehouseBillSubEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
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
