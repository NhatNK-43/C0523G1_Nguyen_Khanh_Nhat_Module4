package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

//    @GetMapping("")
//    public String home(Model model) {
//        List<Blog> blogList = blogService.findAll();
//        model.addAttribute("blogList",blogList);
//        return "list";
//    }

    @GetMapping("")
    public ModelAndView home(@RequestParam(defaultValue = "0", required = false) int page,
                       @RequestParam(defaultValue = "", required = false) String searchName, Model model) {
        Pageable pageable = PageRequest.of(page, 4);
        List<Blog> blogPage = blogService.findAllByTitleContaining(pageable, searchName);
        ModelAndView modelAndView = new ModelAndView("list","blogList", blogPage);
        modelAndView.addObject("searchName", searchName);
        return modelAndView;

    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        blog.setDateOfWriting(Date.valueOf(localDate.format(dateTimeFormatter)));
        redirectAttributes.addFlashAttribute("mess","Create successfully!");
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(Blog blog,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","update successfully!");
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam int id, RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("mess","Delete successfully!");
        redirectAttributes.addFlashAttribute("statusBlog","1");
        blogService.delete(id);
        return "redirect:/";
    }
}