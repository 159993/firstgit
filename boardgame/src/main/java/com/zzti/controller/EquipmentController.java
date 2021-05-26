package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.Equipment;
import com.zzti.pojo.Goods;
import com.zzti.pojo.SysResult;
import com.zzti.serviceImpl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentServiceImpl equipmentServiceImpl;

    @RequestMapping("/selectList")
    @ResponseBody
    public String findAll(Integer page, int limit, HttpServletRequest request,
                          @RequestParam(name = "equipmentName",required =  false ,defaultValue = "") String equipmentName
    ){
        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("equipmentName",equipmentName);
        List<Equipment> aaa = equipmentServiceImpl.selectList(queryMap);
        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        System.out.println(equipmentName);

        List<Equipment> all = equipmentServiceImpl.selectList(queryMap);
        String s = JSON.toJSONString(all);
        return  "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";
    }

    @RequestMapping("/findById/{id}")

    public String findById(@PathVariable("id") Integer id, Model model){
        Equipment equipment = equipmentServiceImpl.findOneGoods(id);

        model.addAttribute("equipment",equipment);

        return "view/equipment/equipment-form.html";
    }
    @RequestMapping("/add")
    @ResponseBody

    public SysResult add(Equipment equipment){
        Equipment equipment1= new Equipment(null,equipment.getName(),equipment.getPrice()
          ,null,equipment.getComment(),null,null,equipment.getType()
                ,null);
        System.out.println(equipment1.toString());
        if(equipmentServiceImpl.add(equipment1)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("/update")
    @ResponseBody
    public SysResult update(Equipment equipment){
        Equipment equipment1= new Equipment(equipment.getId(),equipment.getName(),equipment.getPrice()
                ,equipment.getDamage(),equipment.getComment(),null,null,equipment.getType()
                ,equipment.getUsed());
        if(equipmentServiceImpl.update(equipment1)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public SysResult deleteById(@PathVariable("id") Integer[] ids){
        System.out.println(ids);

        if(equipmentServiceImpl.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }

}
