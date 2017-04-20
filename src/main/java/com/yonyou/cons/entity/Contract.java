package com.yonyou.cons.entity;

public class Contract {
  /**
   * 合同id
   */
  private String conid;
  /**
   * 合同名称
   */
  private String conname;
  /**
   * 签署公司
   */
  private String company;
  /**
   * 开始时间
   */
  private String startDate;
  /**
   * 结束时间
   */
  private String endDate;
  /**
   * 样照
   */
  private String picture;
  /**
   * 状态
   */
  private String state;
  /**
   * 签署人
   */
  private String userid;
  /**
   * 负责人
   */
  private String uid;

  /**
   * 负责人姓名
   */
  private String username;



  public final String getConid() {
    return conid;
  }

  public final void setConid(String conid) {
    this.conid = conid;
  }

  public String getConname() {
    return conname;
  }

  public void setConname(String conName) {
    this.conname = conName;
  }


  public final String getCompany() {
    return company;
  }

  public final void setCompany(String company) {
    this.company = company;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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


  public final String getUsername() {
    return username;
  }

  public final void setUsername(String username) {
    this.username = username;
  }

  public final void setUid(String uid) {
    this.uid = uid;
  }



}
