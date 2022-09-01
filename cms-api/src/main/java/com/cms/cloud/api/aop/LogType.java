package com.cms.cloud.api.aop;

public enum LogType {
    READ("1", "READ"), WRITE("2", "WRITE");

    private final String type;
    private final String desc;

    private LogType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String type() {
        return type;
    }

    public String desc() {
        return desc;
    }
}