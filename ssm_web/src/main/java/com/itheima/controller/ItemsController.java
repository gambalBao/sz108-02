package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Items> list = itemsService.findAll();
        //塞回给页面
        model.addAttribute("items",list);
        return "items";
    }

    @RequestMapping("/save")
    public String save(Items items){
        int save = itemsService.save(items);
        return "redirect:/items/list";
    }
}
