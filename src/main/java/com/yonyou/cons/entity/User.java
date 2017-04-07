package com.yonyou.cons.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
  /**
   * 员工号
   */
  private String userid;
  /**
   * 所属公司
   */
  private String company;
  /**
   * 角色
   */
  private String role;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 性别
   */
  private String sex;
  /**
   * 注册日期
   */
  private String date;
  /**
   * 头像
   */
  private String picture;

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

 
  public final String getUserid() {
    return userid;
  }

  public final void setUserid(String userid) {
    this.userid = userid;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


}
