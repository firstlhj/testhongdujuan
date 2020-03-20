package com.lzs.vo;

import java.io.Serializable;

public class TbFileVO implements Serializable {
    private Integer id;
    private String filePath;

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    private String describes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "TbFileVO{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }
}
