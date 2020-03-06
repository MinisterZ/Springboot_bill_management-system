package com.cuit.springboot.mapper;

import com.cuit.springboot.entities.Bill;
import com.cuit.springboot.entities.BillProvider;
import com.cuit.springboot.entities.Provider;

import java.util.List;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 */

public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deteleBillByBid(Integer bid);


}
