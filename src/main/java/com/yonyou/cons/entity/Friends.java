package com.yonyou.cons.entity;

public class Friends {
  /**
   * 当前用户id
   */
  private String userId;
  /**
   * 好友id
   */
  private String uId;
  /**
   * 关系状态
   */
  private Integer state;

  /**
   * 关联属性User
   */
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
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
