package com.example.pig_management.controller;

import com.example.pig_management.model.Pig;
import com.example.pig_management.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("pigs")
public class PigController {
    @Autowired
    private IPigService pigService;

    @GetMapping("")
    public String showList(Model model){
        List<Pig> pigList = pigService.findAll();
        model.addAttribute("pigList",pigList);
        return "list";
    }
    @GetMapping("search")
    public String searchPig(@RequestParam(defaultValue = "",required = false) String isSold,
                            @RequestParam(defaultValue = "",required = false) String pigCode,
                            @RequestParam(defaultValue = "",required = false) String idOrigin, Model model){
        List<Pig> pigList = pigService.searchPig(isSold,pigCode,idOrigin);
        model.addAttribute("pigList",pigList);
        return "list";
    }
    @GetMapping("delete")
    public  String deletePig(@RequestParam("idDelete") int idDelete, RedirectAttributes redirectAttributes){
        pigService.deletePigById(idDelete);
        redirectAttributes.addFlashAttribute("status","Xóa thành công");
        return "redirect:/pigs";
    }
}
