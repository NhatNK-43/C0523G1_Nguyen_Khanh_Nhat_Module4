package com.example.test.controller;

import com.example.test.dto.BlogDto;
import com.example.test.model.Blog;
import com.example.test.model.Category;
import com.example.test.service.IBlogService;
import com.example.test.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String show(Model model){
//        List<Blog> blogList = blogService.findAll();
          List<Blog> blogList = blogService.getAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model){
        BlogDto blogDto = new BlogDto();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blogDto",blogDto);
        model.addAttribute("categoryList",categoryList);
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute BlogDto blogDto, Model model, RedirectAttributes redirectAttributes){
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("statusPage", 1);
        return "redirect:/";
    }

    @GetMapping("delete")
    public  String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("statusPage", 3);
        return "redirect:/";
    }
}
