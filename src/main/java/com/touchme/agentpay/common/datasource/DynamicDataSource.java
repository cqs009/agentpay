//package com.touchme.agentpay.common.datasource;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///**
// * @program: DynamicDataSource
// * @description: 动态数据源
// * @author: chen qing shan
// * @create: 2019/12/3 18:50
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected Object determineCurrentLookupKey() {
//
//        /**
//         * DynamicDataSourceContextHolder代码中使用setDataSourceType
//         * 设置当前的数据源，在路由类中使用getDataSourceType进行获取，
//         *  交给AbstractRoutingDataSource进行注入使用。
//         */
//        return DynamicDataSourceContextHolder.getDataSourceType();
//    }
//}
