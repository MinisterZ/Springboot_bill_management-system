package com.cuit.springboot.mapper;

import com.cuit.springboot.entities.Provider;

import java.util.List;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 */

public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);//为啥直接传Provider而不是ProviderName 不扩展功能直接传入实体

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);

}
