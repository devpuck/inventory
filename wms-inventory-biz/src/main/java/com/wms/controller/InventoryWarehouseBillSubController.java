package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.InventoryWarehouseBillSubEntity;
import com.wms.service.InventoryWarehouseBillSubService;
import com.wms.api.inventory.InventoryWarehouseBillSubQueryParam;
import com.wms.api.inventory.InventoryWarehouseBillSubVo;
import com.wms.model.bo.inventory.InventoryWarehouseBillSubBo;
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
 * 盘点明细表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-01
 */
@Slf4j
@RestController
@RequestMapping("/inventory")
@Api("盘点明细表 API")
public class InventoryWarehouseBillSubController extends BaseController {

    @Autowired
    private InventoryWarehouseBillSubService inventoryWarehouseBillSubService;

    /**
     * 添加盘点明细表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加InventoryWarehouseBillSub对象", notes = "添加盘点明细表", response = ApiResult.class)
    public ApiResult<Boolean> addInventoryWarehouseBillSub(@Valid @RequestBody InventoryWarehouseBillSubVo inventoryWarehouseBillSub) throws Exception {
         InventoryWarehouseBillSubBo bo = new InventoryWarehouseBillSubBo();
        BeanUtils.copyProperties(inventoryWarehouseBillSub,bo);

        boolean flag = inventoryWarehouseBillSubService.saveInventoryWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改盘点明细表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改InventoryWarehouseBillSub对象", notes = "修改盘点明细表", response = ApiResult.class)
    public ApiResult<Boolean> updateInventoryWarehouseBillSub(@Valid @RequestBody InventoryWarehouseBillSubVo inventoryWarehouseBillSub) throws Exception {
        InventoryWarehouseBillSubBo bo = new InventoryWarehouseBillSubBo();
        BeanUtils.copyProperties(inventoryWarehouseBillSub,bo);

        boolean flag = inventoryWarehouseBillSubService.updateInventoryWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除盘点明细表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除InventoryWarehouseBillSub对象", notes = "删除盘点明细表", response = ApiResult.class)
    public ApiResult<Boolean> deleteInventoryWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        boolean flag = inventoryWarehouseBillSubService.deleteInventoryWarehouseBillSub(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取盘点明细表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取InventoryWarehouseBillSub对象详情", notes = "查看盘点明细表", response = InventoryWarehouseBillSubVo.class)
    public ApiResult<InventoryWarehouseBillSubVo> getInventoryWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        InventoryWarehouseBillSubBo inventoryWarehouseBillSubBo = inventoryWarehouseBillSubService.getInventoryWarehouseBillSubById(id);
        InventoryWarehouseBillSubVo queryVo = null;
        if (inventoryWarehouseBillSubBo != null) {
            queryVo = new InventoryWarehouseBillSubVo();
            BeanUtils.copyProperties(inventoryWarehouseBillSubBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 盘点明细表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取InventoryWarehouseBillSub分页列表", notes = "盘点明细表分页列表", response = InventoryWarehouseBillSubVo.class)
    public ApiResult<Paging<InventoryWarehouseBillSubVo>> getInventoryWarehouseBillSubPageList(@Valid @RequestBody InventoryWarehouseBillSubQueryParam inventoryWarehouseBillSubQueryParam) throws Exception {
        Paging<InventoryWarehouseBillSubBo> paging = inventoryWarehouseBillSubService.getInventoryWarehouseBillSubPageList(inventoryWarehouseBillSubQueryParam);
        Paging<InventoryWarehouseBillSubVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), InventoryWarehouseBillSubVo.class));
        return ApiResult.ok(resultPage);
    }

}

