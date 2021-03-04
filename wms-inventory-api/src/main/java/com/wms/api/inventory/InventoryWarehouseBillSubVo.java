package com.wms.api.inventory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 盘点明细表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "InventoryWarehouseBillSubVo对象", description = "盘点明细表查询参数")
public class InventoryWarehouseBillSubVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "台账ID")
    private String accountId;

    @ApiModelProperty(value = "单据编号")
    private String billCode;

    @ApiModelProperty(value = "编号数量")
    private BigDecimal changeQuantity;

    @ApiModelProperty(value = "盘盈、盘亏")
    private String changeType;

    @ApiModelProperty(value = "盘点人")
    private String inventoryPerson;

    @ApiModelProperty(value = "盘点时间")
    private Date inventoryTime;

}
