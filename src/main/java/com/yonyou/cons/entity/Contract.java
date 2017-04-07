package com.yonyou.cons.entity;

public class Contract {
  /**
   * 合同id
   */
  private String conId;
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
  private String userId;
  /**
   * 负责人
   */
  private String uId;

  public String getConId() {
    return conId;
  }

  public void setConId(String conId) {
    this.conId = conId;
  }

  public String getConname() {
    return conname;
  }

  public void setConname(String conName) {
    this.conname = conName;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    company = company;
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


}
