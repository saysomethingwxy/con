package com.yonyou.cons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cons.Enum.CodeEnum;
import com.yonyou.cons.common.CommonResponse;
import com.yonyou.cons.entity.User;
import com.yonyou.cons.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/regester")
  private CommonResponse regester(@RequestBody User user) {
    try {
      // 非空校验
      if (null == user) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "用户信息不能为空");
      }
      if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())
          || StringUtils.isEmpty(user.getRole()) || StringUtils.isEmpty(user.getUserid())) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "用户信息不能为空");
      }
      // 添加新用户
      user = userService.addUser(user);
    } catch (Exception e) {
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }

    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");

  }

  @RequestMapping(value = "login")
  public CommonResponse login(@RequestBody User loguser, HttpServletRequest request) {
    // 非空校验
    if (null == loguser) {
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "用户信息不能为空");
    }
    if (StringUtils.isEmpty(loguser.getUserid()) || StringUtils.isEmpty(loguser.getPassword())) {
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "用户信息不能为空");
    }
    // 登录验证
    User user = userService.getUserById(loguser);
    if (null == user) {
      return new CommonResponse(CodeEnum.NULLUSER_CODE.getCode(), "用户不存在");
    }
    boolean isLog = userService.checkUserLogin(user, loguser);
    if (!isLog) {
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "用户名密码不匹配");
    }
    // 将用户信息放入session
    request.getSession().setAttribute("user", user);
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
  }

  @RequestMapping(value = "change")
  public CommonResponse changeUser(@RequestBody User user) {
    try {
      // 非空判断
      if (null == user) {
        return new CommonResponse(CodeEnum.NULLUSER_CODE.getCode(), "参数不合法");
      }
      if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getUserid())){
       return new CommonResponse(CodeEnum.NULLUSER_CODE.getCode(), "用户信息不能为空");
      }
      int line = userService.changeUserinfo(user);
      //根据受影响行判断是否插入成功
      if(line<=0){
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "插入数据库失败");
      }
      return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
      } catch (Exception e) {
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
  }
}
