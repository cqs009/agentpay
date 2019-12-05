package com.touchme.agentpay.common.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DynamicDataSourceContextHolder
 * @description: 动态数据源切换器
 * @author: chen qing shan
 * @create: 2019/12/3 18:53
 */
public class DynamicDataSourceContextHolder {

    /**
     * 默认数据源
     */
    private static final String DEFAULT_DS = "dev";



    /**
     * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    /**
     * 管理所有的数据源id;
     * 主要是为了判断数据源是否存在;
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    /**
     * 使用setDataSourceType设置当前的
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
