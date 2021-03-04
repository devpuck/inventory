package com.wms.mapper.inventory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.InventoryWarehouseBillSubEntity;
import com.wms.api.inventory.InventoryWarehouseBillSubQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillSubBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 盘点明细表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Repository
public interface InventoryWarehouseBillSubMapper extends BaseMapper<InventoryWarehouseBillSubEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    InventoryWarehouseBillSubBo getInventoryWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param inventoryWarehouseBillSubQueryParam
     * @return
     */
    IPage<InventoryWarehouseBillSubBo> getInventoryWarehouseBillSubPageList(@Param("page") Page page, @Param("param") InventoryWarehouseBillSubQueryParam inventoryWarehouseBillSubQueryParam);

    /**
     * 删除盘点子单
     * @param billCode
     * @return
     */
    public boolean deleteInventoryWarehouseSubByCode(String billCode);

}
