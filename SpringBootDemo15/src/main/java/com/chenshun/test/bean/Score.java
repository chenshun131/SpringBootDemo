package com.chenshun.test.bean;

/**
 * User: mew <p />
 * Time: 18/4/19 09:46  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Score {

    private String name;

    private String score;

    public Score() {
    }

    public Score(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
