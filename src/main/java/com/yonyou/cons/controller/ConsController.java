package com.yonyou.cons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cons.Enum.CodeEnum;
import com.yonyou.cons.common.CommonResponse;
import com.yonyou.cons.service.ConsService;

@RestController
@RequestMapping(value="/cons")
public class ConsController {

//  @Autowired
//  private ConsService consService;
  @RequestMapping(value="/consinfo",method=RequestMethod.POST)
  public CommonResponse getCons(@RequestParam String userid){
    //非空判断
    if(StringUtils.isEmpty(userid)){
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    
    return null;
    
  }
}
