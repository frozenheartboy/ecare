package com.ecare.web.vo;

import java.io.Serializable;

/**
 * Created by L on 2016/8/1.
 */
public class UserSimpleVo implements Serializable{
    private static final long serialVersionUID = 172948275702700333L;
    private String nickname;
    private String headUrl;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
