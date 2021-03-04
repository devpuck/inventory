package com.wms.api.inventory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 盘点表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "InventoryWarehouseBillVo对象", description = "盘点表查询参数")
public class InventoryWarehouseBillVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "单据编号")
    private String billCode;

    @ApiModelProperty(value = "事务编号")
    private String workCode;

    @ApiModelProperty(value = "库房编号")
    private String warehouseCode;

    @ApiModelProperty(value = "盘点类型")
    private String inventoryType;

    @ApiModelProperty(value = "状态")
    private String status;

    private String version;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "盘点子单列表")
    List<InventoryWarehouseBillSubVo> inventoryWarehouseBillSubVoList;

}
