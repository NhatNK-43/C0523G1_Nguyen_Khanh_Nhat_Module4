package com.example.blog_category.controller;

import com.example.blog_category.dto.BlogDto;
import com.example.blog_category.model.BlogEntity;
import com.example.blog_category.model.CategoryEntity;
import com.example.blog_category.service.IBlogService;
import com.example.blog_category.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Page<BlogEntity>> getList(@RequestParam(defaultValue = "0", required = false) int page){
        Pageable pageable = PageRequest.of(page,3);
        Page<BlogEntity> blogList = blogService.findAll(pageable);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable int id){
        BlogEntity blogEntity = blogService.findById(id);
        if(blogEntity==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogEntity,HttpStatus.OK);
    }

    @GetMapping("/category-list")
    public ResponseEntity<List<CategoryEntity>> getListCategory(){
        List<CategoryEntity> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
}
