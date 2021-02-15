package com.itheima.service.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> findAll() {
        List<Items> list = itemsDao.findAll();
        return list;
    }

    @Transactional
    @Override
    public int save(Items items) {
        int save = itemsDao.save(items);
        System.out.println("影响行数"+save);
        //测试事务，如果出错，是否回滚
        /*int q=10/0;*/
        return save;
    }
}
