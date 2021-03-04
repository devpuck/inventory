package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.bill.BillState;
import com.wms.model.bo.inventory.InventoryWarehouseBillSubBo;
import com.wms.model.entity.InventoryWarehouseBillSubEntity;
import com.wms.service.InventoryWarehouseBillSubService;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.InventoryWarehouseBillEntity;
import com.wms.mapper.inventory.InventoryWarehouseBillMapper;
import com.wms.service.InventoryWarehouseBillService;
import com.wms.api.inventory.InventoryWarehouseBillQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


/**
 * <pre>
 * 盘点表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Slf4j
@Service
public class InventoryWarehouseBillServiceImpl extends BaseServiceImpl<InventoryWarehouseBillMapper, InventoryWarehouseBillEntity> implements InventoryWarehouseBillService
{

    @Autowired
    private InventoryWarehouseBillMapper inventoryWarehouseBillMapper;

    @Autowired
    private InventoryWarehouseBillSubService inventoryWarehouseBillSubService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveInventoryWarehouseBill(InventoryWarehouseBillBo inventoryWarehouseBill) throws Exception
    {

        generateBillCode(inventoryWarehouseBill);

        InventoryWarehouseBillEntity entity = new InventoryWarehouseBillEntity();
        BeanUtils.copyProperties(inventoryWarehouseBill, entity);

        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBill.getInventoryWarehouseBillSubBoList();
        if(null != inventoryWarehouseBillSubBoList)
        {
            List<InventoryWarehouseBillSubEntity> inventoryWarehouseBillSubEntityList = BeanListUtil.copyListProperties(inventoryWarehouseBillSubBoList,InventoryWarehouseBillSubEntity.class);
            boolean updateSubResult = inventoryWarehouseBillSubService.saveBatch(inventoryWarehouseBillSubEntityList);
            if(!updateSubResult)
            {
                return false;
            }
        }
        return super.save(entity);
    }

    public void generateBillCode(InventoryWarehouseBillBo inventoryWarehouseBillBo)
    {
        String billCode = inventoryWarehouseBillBo.getBillCode();
        if (null == billCode)
        {
            billCode = UUID.randomUUID().toString().replaceAll("-", "");
        }

        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBillBo.getInventoryWarehouseBillSubBoList();
        if(null != inventoryWarehouseBillSubBoList)
        {
            Iterator<InventoryWarehouseBillSubBo> it = inventoryWarehouseBillSubBoList.iterator();
            while(it.hasNext())
            {
                InventoryWarehouseBillSubBo inventoryWarehouseBillSubBo = it.next();
                inventoryWarehouseBillSubBo.setBillCode(billCode);
            }
        }
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateInventoryWarehouseBill(InventoryWarehouseBillBo inventoryWarehouseBill) throws Exception
    {
        Long id = inventoryWarehouseBill.getId();
        if(null == id)
        {
            return false;
        }

        InventoryWarehouseBillBo inventoryWarehouseBillBo = getInventoryWarehouseBillById(id);
        if(null == inventoryWarehouseBillBo)
        {
            return false;
        }

        String billState = inventoryWarehouseBillBo.getStatus();
        if(!BillState.CREATE_STATE.equals(billState))
        {
            return false;
        }

        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBill.getInventoryWarehouseBillSubBoList();
        if(null != inventoryWarehouseBillSubBoList)
        {
            List<InventoryWarehouseBillSubEntity> inventoryWarehouseBillSubEntityList = BeanListUtil.copyListProperties(inventoryWarehouseBillSubBoList,InventoryWarehouseBillSubEntity.class);
            boolean updateSubResult = inventoryWarehouseBillSubService.saveOrUpdateBatch(inventoryWarehouseBillSubEntityList);
            if(!updateSubResult)
            {
                return false;
            }
        }

        InventoryWarehouseBillEntity entity = new InventoryWarehouseBillEntity();
        BeanUtils.copyProperties(inventoryWarehouseBill, entity);
        return super.updateById(entity);
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteInventoryWarehouseBill(Long id) throws Exception
    {
        InventoryWarehouseBillBo inventoryWarehouseBillBo = getInventoryWarehouseBillById(id);
        if(null == inventoryWarehouseBillBo)
        {
            return true;
        }

        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBillBo.getInventoryWarehouseBillSubBoList();
        if(null != inventoryWarehouseBillSubBoList)
        {
            inventoryWarehouseBillSubService.deleteInventoryWarehouseBillSubByCode(inventoryWarehouseBillBo.getBillCode());
        }
        return super.removeById(id);
    }

    @Override
    public InventoryWarehouseBillBo getInventoryWarehouseBillById(Serializable id) throws Exception
    {
        InventoryWarehouseBillBo inventoryWarehouseBillBo = inventoryWarehouseBillMapper.getInventoryWarehouseBillById(id);
        if(null == inventoryWarehouseBillBo)
        {
            return null;
        }

        String billCode = inventoryWarehouseBillBo.getBillCode();
        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBillSubService.queryInventoryWarehouseBillSub(billCode);
        inventoryWarehouseBillBo.setInventoryWarehouseBillSubBoList(inventoryWarehouseBillSubBoList);

        return inventoryWarehouseBillBo;
    }

    @Override
    public InventoryWarehouseBillBo queryInventoryWarehouseBillByCode(String billCode) throws Exception
    {
        InventoryWarehouseBillEntity inventoryWarehouseBillEntity = inventoryWarehouseBillMapper.selectOne(new QueryWrapper<InventoryWarehouseBillEntity>().lambda().eq(InventoryWarehouseBillEntity::getBillCode,billCode));
        if(null == inventoryWarehouseBillEntity)
        {
            return null;
        }

        InventoryWarehouseBillBo inventoryWarehouseBillBo = new InventoryWarehouseBillBo();
        BeanUtils.copyProperties(inventoryWarehouseBillEntity,inventoryWarehouseBillBo);

        List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = inventoryWarehouseBillSubService.queryInventoryWarehouseBillSub(billCode);
        inventoryWarehouseBillBo.setInventoryWarehouseBillSubBoList(inventoryWarehouseBillSubBoList);

        return inventoryWarehouseBillBo;
    }

    @Override
    public Paging<InventoryWarehouseBillBo> getInventoryWarehouseBillPageList(InventoryWarehouseBillQueryParam inventoryWarehouseBillQueryParam)
    {
        Page page = setPageParam(inventoryWarehouseBillQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<InventoryWarehouseBillBo> iPage = inventoryWarehouseBillMapper.getInventoryWarehouseBillPageList(page, inventoryWarehouseBillQueryParam);
        return new Paging(iPage);
    }

    @Override
    public String queryBillIdByCode(String billCode)
    {
        return inventoryWarehouseBillMapper.queryBillIdByCode(billCode);
    }

}
