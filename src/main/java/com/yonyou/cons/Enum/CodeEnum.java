package com.yonyou.cons.Enum;

public enum CodeEnum {
  SUCCESS_CODE("0000"), NULLUSER_CODE("1001"), FAIL_CODE("9999"),NULL_CODE("1002"),IMG_CODE("1003");

  String code;

  CodeEnum(String code) {
    this.code = code;
  }

  public final String getCode() {
    return code;
  }

  public final void setCode(String code) {
    this.code = code;
  }


}
