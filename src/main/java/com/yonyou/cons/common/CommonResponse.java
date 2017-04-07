package com.yonyou.cons.common;

import org.springframework.stereotype.Component;

/**
 * 通用返回对象，如果后续要合并到piaoeda，替换成util中的内容
 * 
 * @author gaotx
 *
 */
public class CommonResponse {

    private String code;

    private String msg;

    private Object datas;

    public CommonResponse(String code, String msg) {
      this.setCode(code);
      this.setMsg(msg);
    }

    public CommonResponse(String code, String msg, Object datas) {
      this.setCode(code);
      this.setMsg(msg);
      this.setDatas(datas);
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    /**
     * @return the datas
     */
    public Object getDatas() {
      return datas;
    }

    /**
     * @param datas the datas to set
     */
    public void setDatas(Object datas) {
      this.datas = datas;
    }
}
