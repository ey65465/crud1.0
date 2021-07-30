package com.myapp.crud.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myapp.crud.pojo.Product;
import com.myapp.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    // 页面跳转
    @RequestMapping(value="/listProduct", method = RequestMethod.GET)
    public ModelAndView listProduct(){
        ModelAndView mav = new ModelAndView("listProduct");
        return mav;
    }
    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public ModelAndView editProduct(){
        ModelAndView mav = new ModelAndView("editProduct");
        return mav;
    }
    // restful部分
    @GetMapping("/products")
    public PageInfo<Product> list(@RequestParam(value="start", defaultValue = "1") int start,
                                  @RequestParam(value="size", defaultValue = "5") int size,
                                  @RequestParam(value="cid", defaultValue = "0") int cid){
        PageHelper.startPage(start, size, "id desc");
        List<Product> products;
        if(cid == 0)
            products = productService.list();
        else
            products = productService.listByCid(cid);
        PageInfo<Product> page = new PageInfo<>(products, 5);
        return page;
    }
    @PostMapping("/products")
    public String add(@RequestBody Product product){
        productService.add(product);
        return "success";
    }
    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id){
        Product p = productService.get(id);
        return p;
    }
    @PostMapping("/products/{id}")
    public String update(@RequestBody Product product){
        productService.update(product);
        return "success";
    }
}
