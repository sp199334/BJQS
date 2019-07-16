package com.home.crm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


/**
  * 类名：SysLog.java
  * 类说明： 系统日志
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Entity
public class SysLog {
    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Long logId;
    @Column(nullable = false,length = 60)
    private String userName;
    @Column(length = 30)
    private String host;
    @Column(nullable = false)
    private String action;
    private String event;
    @Column(nullable = false)
    private LocalDateTime insertTime;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "logId=" + logId +
                ", userName='" + userName + '\'' +
                ", host='" + host + '\'' +
                ", action='" + action + '\'' +
                ", event='" + event + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
