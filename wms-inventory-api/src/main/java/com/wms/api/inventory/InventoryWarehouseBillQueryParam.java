package com.wms.api.inventory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 盘点表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "InventoryWarehouseBillQueryParam对象", description = "盘点表查询参数")
public class InventoryWarehouseBillQueryParam extends SortQueryParam
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事务编号")
    private String workCode;

    @ApiModelProperty(value = "库房编号")
    private String warehouseCode;

    @ApiModelProperty(value = "盘点类型")
    private String inventoryType;

    @ApiModelProperty(value = "状态")
    private String status;
}
