package com.wms.service;

import com.wms.model.entity.InventoryWarehouseBillEntity;
import com.xac.core.service.BaseService;
import com.wms.api.inventory.InventoryWarehouseBillQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 盘点表 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
public interface InventoryWarehouseBillService extends BaseService<InventoryWarehouseBillEntity> {

    /**
     * 保存
     *
     * @param inventoryWarehouseBill
     * @return
     * @throws Exception
     */
    boolean saveInventoryWarehouseBill(InventoryWarehouseBillBo inventoryWarehouseBill) throws Exception;

    /**
     * 修改
     *
     * @param inventoryWarehouseBill
     * @return
     * @throws Exception
     */
    boolean updateInventoryWarehouseBill(InventoryWarehouseBillBo inventoryWarehouseBill) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteInventoryWarehouseBill(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    InventoryWarehouseBillBo getInventoryWarehouseBillById(Serializable id) throws Exception;

    /**
     * 根据单据编号查询盘点单据
     * @param billCode
     * @return
     */
    InventoryWarehouseBillBo queryInventoryWarehouseBillByCode(String billCode) throws Exception;

    /**
     * 获取分页对象
     *
     * @param inventoryWarehouseBillQueryParam
     * @return
     * @throws Exception
     */
    Paging<InventoryWarehouseBillBo> getInventoryWarehouseBillPageList(InventoryWarehouseBillQueryParam inventoryWarehouseBillQueryParam);

    /**
     * 根据单据编号查询单据id
     * @param billCode
     * @return
     */
    public String queryBillIdByCode(String billCode);
}
