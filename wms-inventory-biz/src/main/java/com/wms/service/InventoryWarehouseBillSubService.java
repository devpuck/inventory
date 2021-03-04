package com.wms.service;

import com.wms.model.entity.InventoryWarehouseBillSubEntity;
import com.xac.core.service.BaseService;
import com.wms.api.inventory.InventoryWarehouseBillSubQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillSubBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 盘点明细表 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
public interface InventoryWarehouseBillSubService extends BaseService<InventoryWarehouseBillSubEntity> {

    /**
     * 保存
     *
     * @param inventoryWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean saveInventoryWarehouseBillSub(InventoryWarehouseBillSubBo inventoryWarehouseBillSub);

    /**
     * 修改
     *
     * @param inventoryWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean updateInventoryWarehouseBillSub(InventoryWarehouseBillSubBo inventoryWarehouseBillSub);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteInventoryWarehouseBillSub(Long id);

    /**
     * 批量删除盘点单据子单
     * @param billCode
     * @return
     */
    boolean deleteInventoryWarehouseBillSubByCode(String billCode);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    InventoryWarehouseBillSubBo getInventoryWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param inventoryWarehouseBillSubQueryParam
     * @return
     * @throws Exception
     */
    Paging<InventoryWarehouseBillSubBo> getInventoryWarehouseBillSubPageList(InventoryWarehouseBillSubQueryParam inventoryWarehouseBillSubQueryParam);

    /**
     * 查询盘点子单
     * @param billCode
     * @return
     */
    List<InventoryWarehouseBillSubBo> queryInventoryWarehouseBillSub(String billCode) throws Exception;

}
