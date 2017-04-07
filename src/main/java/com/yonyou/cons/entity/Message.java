package com.yonyou.cons.entity;

public class Message {
  /**
   * 合同id
   */
  private String conId;
  /**
   * 发送人
   */
  private String userId;
  /**
   * 被提醒人
   */
  private String uId;
  /**
   * 消息
   */
  private String message;
  /**
   * 时间
   */
  private String date;

  public String getConId() {
    return conId;
  }

  public void setConId(String conId) {
    this.conId = conId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


}
