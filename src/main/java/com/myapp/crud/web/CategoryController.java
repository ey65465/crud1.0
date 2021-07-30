package com.myapp.crud.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myapp.crud.pojo.Category;
import com.myapp.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
//    页面跳转
    @RequestMapping(value="/listCategory", method = RequestMethod.GET)
    public ModelAndView listCategory(){
        ModelAndView mav = new ModelAndView("listCategory");
        return mav;
    }
    @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
    public ModelAndView editCategory(){
        ModelAndView mav = new ModelAndView("editCategory");
        return mav;
    }
//    Restful部分
    @GetMapping("/categories")
    public PageInfo<Category> list(@RequestParam(value="start", defaultValue = "1") int start,
                                   @RequestParam(value="size", defaultValue = "5") int size){
        PageHelper.startPage(start, size, "id desc");
        List<Category> cs = categoryService.list();
        PageInfo<Category> page = new PageInfo<>(cs, 5); // 5表示导航分页最多5个
        return page;
    }
    @GetMapping("/categories/all")
    public List<Category> list(){
        List<Category> cs = categoryService.list();
        return cs;
    }
    @PostMapping("/categories")
    public String add(@RequestBody Category category){
        categoryService.add(category);
        System.out.println(category.getName());
        return "success";
    }
    @DeleteMapping("/categories/{id}")
    public String delete(Category category){
        System.out.println(category.getId());
        categoryService.delete(category.getId());
        return "success";
    }
    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id){
        System.out.println(id);
        Category c = categoryService.get(id);
        return c;
    }
    @PostMapping("/categories/{id}")
    public String update(@RequestBody Category category){
        categoryService.update(category);
        return "success";
    }
}
