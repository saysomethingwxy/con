package com.yonyou.cons.entity;

public class Message {
  /**
   * 合同id
   */
  private String cid;
  /**
   * 发送人
   */
  private String userid;
  /**
   * 被提醒人
   */
  private String uid;
  /**
   * 消息
   */
  private String message;
  /**
   * 时间
   */
  private String date;
 
  public final String getCid() {
    return cid;
  }
  public final void setCid(String cid) {
    this.cid = cid;
  }
  public final String getUserid() {
    return userid;
  }
  public final void setUserid(String userid) {
    this.userid = userid;
  }
  public final String getUid() {
    return uid;
  }
  public final void setUid(String uid) {
    this.uid = uid;
  }
  public final String getMessage() {
    return message;
  }
  public final void setMessage(String message) {
    this.message = message;
  }
  public final String getDate() {
    return date;
  }
  public final void setDate(String date) {
    this.date = date;
  }
}
