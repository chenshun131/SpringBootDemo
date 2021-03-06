package com.chenshun.test.bean;

/**
 * User: mew <p />
 * Time: 18/3/13 13:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Msg {

    private String title;

    private String content;

    private String extraInfo;

    public Msg(String title, String content, String extraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

}
