package com.cuit.springboot.controller;

import com.cuit.springboot.entities.Bill;
import com.cuit.springboot.entities.BillProvider;
import com.cuit.springboot.entities.Provider;
import com.cuit.springboot.mapper.BillMapper;
import com.cuit.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 */

@Controller
public class BillController {
    @Autowired
    BillMapper billMapper;

    @Autowired
    ProviderMapper providerMapper;

    Logger  logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/bills")                       //单个查询才会有Bill bill值   查询所有是没值的
    public String list(Map<String, Object> map, Bill bill) {

        System.out.println("a"+bill.getBillName()+ "b"+bill.getPid()+"c"+bill.getPay());
        logger.info("账单列表查询"+bill);


                                                   //单个查询就会有Bill bill
        List<BillProvider> billProviders= billMapper.getBills(bill);
        //获取所有供应商                                     null即查询所有
        List<Provider> providers= providerMapper.getProviders(null);


        map.put("billProviders", billProviders);
        map.put("providers", providers);
        System.out.println("a"+bill.getBillName()+ "b"+bill.getPid()+"c"+bill.getPay());
        //回显  因为查询了getProviders也就得到了所有属性    bill.get是当前选择的这行数据的属性值
        map.put("billName", bill.getBillName());
        map.put("pid", bill.getPid());
        map.put("pay",bill.getPay());
        return "bill/list";
    }



    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + bid + "的帐单详细信息");
        BillProvider billProvider = billMapper.getBillByBid(bid);
        map.put("billProvider", billProvider);
        //查询所有供应商
        if ("update".equals(type)) {
            map.put("providers", providerMapper.getProviders(null));
        }
        //type = null 则进入view.html，type = update 则是进入update.html
        return "bill/"+ type;
    }


    //修改信息
    @PutMapping("/bill")
    public  String update(Bill bill){
        logger.info("更改供应商信息。。。");

        billMapper.updateBill(bill);

        return "redirect:bills";
    }

    //前往添加页面
    @GetMapping("/bill")
    public String toAddPage(Map<String,Object>map){
//        List<Provider>providers=providerMapper.getProviders(null);
        map.put("providers",providerMapper.getProviders(null));
        return "bill/add";
    }

    //添加操作
    @PostMapping("/bill")
    public String add(Bill bill){
        logger.info("添加供应商数据"+bill);

        //添加
        billMapper.addBill(bill);
        return "redirect:/bills";
    }

    //删除供应商
    @DeleteMapping("/bill/{bid}" )
    public String delete(@PathVariable("bid")Integer bid){

        logger.info("删除操作，bid="+bid);
         billMapper.deteleBillByBid(bid);


        return "redirect:/bills";
    }


}