package com.chenshun.test.mqtt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * User: chenshun131 <p />
 * Time: 18/10/7 12:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@Data
@AllArgsConstructor
public class PushPayload {

    //推送类型
    private String type;

    //推送对象
    private String mobile;

    //标题
    private String title;

    //内容
    private String content;

    //数量
    private Integer badge = 1;

    //铃声
    private String sound = "default";

    public static class Builder {

        //推送类型
        private String type;

        //推送对象
        private String mobile;

        //标题
        private String title;

        //内容
        private String content;

        //数量
        private Integer badge = 1;

        //铃声
        private String sound = "default";

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setBadge(Integer badge) {
            this.badge = badge;
            return this;
        }

        public Builder setSound(String sound) {
            this.sound = sound;
            return this;
        }

        public PushPayload bulid() {
            return new PushPayload(type, mobile, title, content, badge, sound);
        }
    }

    public static Builder getPushPayloadBuider() {
        return new Builder();
    }

}
