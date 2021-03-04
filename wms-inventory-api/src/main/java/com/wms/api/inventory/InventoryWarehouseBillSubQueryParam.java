package com.wms.api.inventory;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 盘点明细表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "InventoryWarehouseBillSubQueryParam对象", description = "盘点明细表查询参数")
public class InventoryWarehouseBillSubQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
