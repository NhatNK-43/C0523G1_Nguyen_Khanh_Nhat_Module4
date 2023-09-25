package com.example.register_form.controller;

import com.example.register_form.dto.UserDto;
import com.example.register_form.model.User;
import com.example.register_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("")
    public String showList(Model model){
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList",userList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Create successfully!");
        return "redirect:/user";
    }
}
