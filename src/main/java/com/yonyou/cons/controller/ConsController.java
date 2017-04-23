package com.yonyou.cons.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yonyou.cons.Enum.CodeEnum;
import com.yonyou.cons.common.CommonResponse;
import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.Message;
import com.yonyou.cons.service.ConsService;
import com.yonyou.cons.service.MessService;
import com.yonyou.cons.service.UserService;

@RestController
@RequestMapping(value = "/cons")
public class ConsController {

  @Autowired
  private ConsService consService;

  @Autowired
  private UserService userService;

  @Autowired
  private MessService messSevice;

  @RequestMapping(value = "/consinfo", method = RequestMethod.GET)
  public CommonResponse getCons(@RequestParam String userid) {
    List<Contract> cons = new ArrayList<Contract>();
    List<Message> messages = null;
    List datas = new ArrayList();
    // 非空判断
    if (StringUtils.isEmpty(userid)) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    try {
      cons = consService.getConsByUserid(userid);
      if (cons != null) {
        messages = getMess(cons);
      }
      // 封装合同信息和提醒消息
      datas.add(cons);
      datas.add(messages);
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功", datas);
  }

  /**
   * 
   * @Title:getMess
   * @Description:TODO 根据获取的合同顺序依次获取提醒信息
   * @param cons
   * @return
   * @author winxinyuan
   */
  private List<Message> getMess(List<Contract> cons) {
    List<Message> mess = new ArrayList<Message>();
    for (Contract con : cons) {
      Message message = messSevice.getMessageByCid(con.getConid());
      mess.add(message);
    }
    return mess;
  }

  /**
   * 
   * @Title:endCon
   * @Description:TODO 结束合同，修改合同执行状态
   * @param conid
   * @return
   * @author winxinyuan
   */
  @RequestMapping(value = "/endcon", method = RequestMethod.GET)
  public CommonResponse endCon(@RequestParam String conid) {
    // 非空判断
    if (StringUtils.isEmpty(conid)) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    try {
      int line = consService.updateCon(conid);
      if (line <= 0) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "修改数据库不成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
  }

  /**
   * 
   * @Title:getConsByWord
   * @Description:TODO 根据合同关键字查找合同信息
   * @param word
   * @return
   * @author winxinyuan
   * @throws UnsupportedEncodingException
   */
  @RequestMapping(value = "/getcons", method = RequestMethod.GET)
  public CommonResponse getConsByWord(@RequestParam String word, @RequestParam String userid)
      throws UnsupportedEncodingException {
    word = new String(word.getBytes("iso-8859-1"), "utf-8");
    List<Message> messages = null;
    List datas = new ArrayList();
    // 非空判断
    if (StringUtils.isEmpty(word)) {
      word = "/";
    }
    try {
      List<Contract> cons = consService.getConsByWord(word, userid);
      if (cons != null) {
        messages = getMess(cons);
      }
      datas.add(cons);
      datas.add(messages);
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功", datas);
  }

  /**
   * 
   * @Title:addCon
   * @Description:TODO 添加一个新合同
   * @param request
   * @param response
   * @return
   * @throws IllegalStateException
   * @throws IOException
   * @author winxinyuan
   */
  @RequestMapping(value = "/addcon", method = RequestMethod.POST)
  public CommonResponse addCon(HttpServletRequest request, HttpServletResponse response)
      throws IllegalStateException, IOException {
    try {
      // 获取属性
      String conid = request.getParameter("conid");
      String conname = request.getParameter("conname");
      String starttime = request.getParameter("starttime");
      String endtime = request.getParameter("endtime");
      String company = request.getParameter("company");
      String uname = request.getParameter("uname");
      String username = request.getParameter("username");
      String state = request.getParameter("state");
      String img = null;
      // 非空判断
      if (StringUtils.isEmpty(conid) || StringUtils.isEmpty(conname)
          || StringUtils.isEmpty(starttime) || StringUtils.isEmpty(endtime)
          || StringUtils.isEmpty(company) || StringUtils.isEmpty(uname)
          || StringUtils.isEmpty(username)) {
        return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
      }
      // 存在判断
      // Contract con=consService.
      Contract con = new Contract();
      con.setCompany(company);
      con.setConid(conid);
      con.setConname(conname);
      con.setEndDate(endtime);
      con.setStartDate(starttime);
      con.setUid(uname);
      con.setUserid(username);
      con.setState(state);
      CommonsMultipartResolver multipartResolver =
          new CommonsMultipartResolver(request.getSession().getServletContext());
      // 判断request是否有文件上传
      if (multipartResolver.isMultipart(request)) {
        // 图片名字存储器
        StringBuilder names = new StringBuilder();
        // 转换成多部分request
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        // 获取request所有上传的文件名
        Iterator<String> it = req.getFileNames();

        while (it.hasNext()) {
          // 得到上传文件
          MultipartFile file = req.getFile(it.next());
          // 判断文件是否存在
          if (file != null) {
            // 判断文件名是否是空
            String filename = file.getOriginalFilename();
            if (filename != "") {
              String pfix = filename.substring(filename.length() - 4, filename.length());
              if (!pfix.equals(".jpg") && !pfix.equals(".bmp") && !pfix.equals(".png")
                  && !pfix.equals(".gif")) {
                return new CommonResponse(CodeEnum.IMG_CODE.getCode(), "图片格式不正确");
              }
              filename = UUID.randomUUID().toString().replace("-", "");
              // 定义上传路径
//              String path =
//                  request.getServletContext().getRealPath("/cons") + "\\" + filename + pfix;
              String path="C:\\Users\\Administrator\\git\\yonyoucon\\src\\main\\webapp\\cons\\" + filename + pfix;
              names.append("#").append(filename).append(pfix);
              // 上传文件
              file.transferTo(new File(path));
            }
          }
        }
        img = names.toString();
      }
      con.setPicture(img);
      // 插入一条新数据
      int line = consService.addCon(con);
      if (line <= 0) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "合同插入数据库失败");
      }
      // 插入一条新预制信息
      Message msg = new Message();
      msg.setCid(conid);
      msg.setDate("0000-00-00");
      msg.setUid(uname);
      msg.setUserid(username);
      msg.setMessage("--");
      line = messSevice.addBaseMess(msg);
      if (line <= 0) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "信息插入数据库失败");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
  }

  /**
   * 
   *@Title:getImgs  
   * @Description:TODO 获取合同详细图片信息
   * @param conid
   * @return
   * @author winxinyuan
   */
  @RequestMapping(value="/getimg", method = RequestMethod.GET)
  public CommonResponse getImgs(@RequestParam String conid){
    List<String> imgs=null;
    //非空判断
    if (StringUtils.isEmpty(conid)) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    try {
      //获取合同信息
      Contract con=consService.getConByCid(conid);
      if(con!=null){
        imgs=consService.getImgs(con.getPicture());
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功",imgs);
  }

}
