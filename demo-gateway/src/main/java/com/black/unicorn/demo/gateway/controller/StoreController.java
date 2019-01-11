/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.black.unicorn.demo.gateway.controller;

import com.black.unicorn.demo.common.response.ResponseResult;
import com.black.unicorn.demo.gateway.view.request.store.StoreRequest;
import com.black.unicorn.demo.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Store")
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "新增Store", notes = "新增Store")
    @PostMapping("/insert")
    public ResponseResult insertStore(@RequestBody @Valid StoreRequest storeRequest) {
        long id = storeService.insertOrUpdate(storeRequest);
        return ResponseResult.success(id);
    }


    @ApiOperation(value = "修改Store", notes = "修改Store")
    @PostMapping("/edit/{id}")
    public ResponseResult editStore(@PathVariable(value = "id") Long id, @RequestBody @Valid StoreRequest storeRequest) {
        storeRequest.setId(id);
        long result = storeService.insertOrUpdate(storeRequest);
        return ResponseResult.success(result);
    }


    @ApiOperation(value = "修改Store", notes = "修改Store")
    @DeleteMapping("/delete/{id}")
    public ResponseResult editStore(@PathVariable(value = "id") Long id) {
        boolean result = storeService.deleteByPrimaryKey(id);
        return ResponseResult.success(result);
    }


    @ApiOperation(value = "查找Store", notes = "查找Store")
    @GetMapping("/search")
    public ResponseResult editStore(@Valid) {
        boolean result = storeService.deleteByPrimaryKey(id);
        return ResponseResult.success(result);
    }

}
