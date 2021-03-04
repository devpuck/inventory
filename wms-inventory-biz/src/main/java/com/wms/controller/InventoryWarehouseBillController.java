package com.wms.controller;

import com.wms.errorcode.ErrorCode;
import com.wms.util.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.service.InventoryWarehouseBillService;
import com.wms.api.inventory.InventoryWarehouseBillQueryParam;
import com.wms.api.inventory.InventoryWarehouseBillVo;
import com.wms.model.bo.inventory.InventoryWarehouseBillBo;
import com.xac.core.api.ApiResult;
import com.xac.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.xac.core.api.Paging;

/**
 * <pre>
 * 盘点表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Slf4j
@RestController
@RequestMapping("/inventory")
@Api("盘点表 API")
public class InventoryWarehouseBillController extends BaseController
{

    @Autowired
    private InventoryWarehouseBillService inventoryWarehouseBillService;

    /**
     * 添加盘点表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加InventoryWarehouseBill对象", notes = "添加盘点表", response = ApiResult.class)
    public ApiResult<Boolean> addInventoryWarehouseBill(@Valid @RequestBody InventoryWarehouseBillVo inventoryWarehouseBill) throws Exception
    {
        String billCode = inventoryWarehouseBill.getBillCode();
        if(null == billCode || "".equals(billCode))
        {
            String id = inventoryWarehouseBillService.queryBillIdByCode(billCode);
            if(null != id)
            {

            }
        }

        String workCode = inventoryWarehouseBill.getWorkCode();
        if (ErrorCode.OK != CheckParameter.checkParameter(workCode))
        {
            log.error("Create inventory bill error!Parameter error!workCode:" + workCode);
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        InventoryWarehouseBillBo bo = new InventoryWarehouseBillBo();
        BeanUtils.copyProperties(inventoryWarehouseBill, bo);

        boolean flag = inventoryWarehouseBillService.saveInventoryWarehouseBill(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改盘点表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改InventoryWarehouseBill对象", notes = "修改盘点表", response = ApiResult.class)
    public ApiResult<Boolean> updateInventoryWarehouseBill(@Valid @RequestBody InventoryWarehouseBillVo inventoryWarehouseBill) throws Exception
    {
        InventoryWarehouseBillBo bo = new InventoryWarehouseBillBo();
        BeanUtils.copyProperties(inventoryWarehouseBill, bo);

        boolean flag = inventoryWarehouseBillService.updateInventoryWarehouseBill(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除盘点表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除InventoryWarehouseBill对象", notes = "删除盘点表", response = ApiResult.class)
    public ApiResult<Boolean> deleteInventoryWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = inventoryWarehouseBillService.deleteInventoryWarehouseBill(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取盘点表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取InventoryWarehouseBill对象详情", notes = "查看盘点表", response = InventoryWarehouseBillVo.class)
    public ApiResult<InventoryWarehouseBillVo> getInventoryWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        InventoryWarehouseBillBo inventoryWarehouseBillBo = inventoryWarehouseBillService.getInventoryWarehouseBillById(id);
        InventoryWarehouseBillVo queryVo = null;
        if (inventoryWarehouseBillBo != null)
        {
            queryVo = new InventoryWarehouseBillVo();
            BeanUtils.copyProperties(inventoryWarehouseBillBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 盘点表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取InventoryWarehouseBill分页列表", notes = "盘点表分页列表", response = InventoryWarehouseBillVo.class)
    public ApiResult<Paging<InventoryWarehouseBillVo>> getInventoryWarehouseBillPageList(@Valid @RequestBody InventoryWarehouseBillQueryParam inventoryWarehouseBillQueryParam) throws Exception
    {
        Paging<InventoryWarehouseBillBo> paging = inventoryWarehouseBillService.getInventoryWarehouseBillPageList(inventoryWarehouseBillQueryParam);
        Paging<InventoryWarehouseBillVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), InventoryWarehouseBillVo.class));
        return ApiResult.ok(resultPage);
    }

}

