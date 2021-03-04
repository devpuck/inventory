package com.wms.mapper.inventory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.InventoryWarehouseBillEntity;
import com.wms.api.inventory.InventoryWarehouseBillQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 盘点表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Repository
public interface InventoryWarehouseBillMapper extends BaseMapper<InventoryWarehouseBillEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    InventoryWarehouseBillBo getInventoryWarehouseBillById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param inventoryWarehouseBillQueryParam
     * @return
     */
    IPage<InventoryWarehouseBillBo> getInventoryWarehouseBillPageList(@Param("page") Page page, @Param("param") InventoryWarehouseBillQueryParam inventoryWarehouseBillQueryParam);

    /**
     * 根据单据编号查询单据ID
     * @param billCode
     * @return
     */
    public String queryBillIdByCode(String billCode);

}
