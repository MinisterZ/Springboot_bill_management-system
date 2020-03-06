package com.cuit.springboot.entities;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 *
 *      封装新的实体，因为账单列表还有详情都要有供应商名称
 */

public class BillProvider extends Bill{
    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
