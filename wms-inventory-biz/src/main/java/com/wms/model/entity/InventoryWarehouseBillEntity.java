package com.wms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 盘点表
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_INVENTORY_WAREHOUSE_BILL")
public class InventoryWarehouseBillEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
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

}
