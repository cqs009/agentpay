package com.touchme.agentpay.common.enums;

/**
 * @program: DataSourceEnum
 * @description: 数据源枚举
 * @author: chen qing shan
 * @create: 2019/12/3 18:58
 */
public enum DataSourceEnum {

    DEV("dev"),PRO("pro");

    private String value;

    DataSourceEnum(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}
