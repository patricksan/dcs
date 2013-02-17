package com.moogu.dcs.shared.utils;

public enum DcsEnvironmentEnum {

    DEV("DEV"), TEST("TEST"), QA("QA"), PROD("PROD");

    private final String environment;

    public static DcsEnvironmentEnum toEnum(String text) {
        for (final DcsEnvironmentEnum type : DcsEnvironmentEnum.values()) {
            if (type.environment.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }

    DcsEnvironmentEnum(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return this.environment;
    }
}
