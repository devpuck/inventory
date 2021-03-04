package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.InventoryWarehouseBillSubEntity;
import com.wms.mapper.inventory.InventoryWarehouseBillSubMapper;
import com.wms.service.InventoryWarehouseBillSubService;
import com.wms.api.inventory.InventoryWarehouseBillSubQueryParam;
import com.wms.model.bo.inventory.InventoryWarehouseBillSubBo;
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
import java.util.List;


/**
 * <pre>
 * 盘点明细表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Slf4j
@Service
public class InventoryWarehouseBillSubServiceImpl extends BaseServiceImpl<InventoryWarehouseBillSubMapper, InventoryWarehouseBillSubEntity> implements InventoryWarehouseBillSubService
{

    @Autowired
    private InventoryWarehouseBillSubMapper inventoryWarehouseBillSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveInventoryWarehouseBillSub(InventoryWarehouseBillSubBo inventoryWarehouseBillSub)
    {
        InventoryWarehouseBillSubEntity entity = new InventoryWarehouseBillSubEntity();
        BeanUtils.copyProperties(inventoryWarehouseBillSub, entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateInventoryWarehouseBillSub(InventoryWarehouseBillSubBo inventoryWarehouseBillSub)
    {
        InventoryWarehouseBillSubEntity entity = new InventoryWarehouseBillSubEntity();
        BeanUtils.copyProperties(inventoryWarehouseBillSub, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteInventoryWarehouseBillSub(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public boolean deleteInventoryWarehouseBillSubByCode(String billCode)
    {
        return inventoryWarehouseBillSubMapper.deleteInventoryWarehouseSubByCode(billCode);
    }

    @Override
    public InventoryWarehouseBillSubBo getInventoryWarehouseBillSubById(Serializable id)
    {
        return inventoryWarehouseBillSubMapper.getInventoryWarehouseBillSubById(id);
    }

    @Override
    public Paging<InventoryWarehouseBillSubBo> getInventoryWarehouseBillSubPageList(InventoryWarehouseBillSubQueryParam inventoryWarehouseBillSubQueryParam)
    {
        Page page = setPageParam(inventoryWarehouseBillSubQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<InventoryWarehouseBillSubBo> iPage = inventoryWarehouseBillSubMapper.getInventoryWarehouseBillSubPageList(page, inventoryWarehouseBillSubQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<InventoryWarehouseBillSubBo> queryInventoryWarehouseBillSub(String billCode) throws Exception
    {
        List<InventoryWarehouseBillSubEntity> inventoryWarehouseBillSubEntityList = inventoryWarehouseBillSubMapper.selectList(new QueryWrapper<InventoryWarehouseBillSubEntity>().lambda().eq(InventoryWarehouseBillSubEntity::getBillCode,billCode));
        if(null != inventoryWarehouseBillSubEntityList)
        {
            List<InventoryWarehouseBillSubBo> inventoryWarehouseBillSubBoList = BeanListUtil.copyListProperties(inventoryWarehouseBillSubEntityList,InventoryWarehouseBillSubBo.class);
            return inventoryWarehouseBillSubBoList;
        }

        return null;
    }

}
