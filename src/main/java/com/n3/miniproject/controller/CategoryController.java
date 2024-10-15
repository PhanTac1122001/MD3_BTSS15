package com.n3.miniproject.controller;

import com.n3.miniproject.model.entity.Category;
import com.n3.miniproject.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/category"})
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    @GetMapping("/add")
    public String addCate(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add-category")
    public String create(@ModelAttribute("category") Category category, Model model) {
        boolean bl = categoryService.addCate(category);
        if (bl) {
            return "redirect:/category";
        } else {
            model.addAttribute("category", category);
            return "category/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("category") Category category, Model model) {
        if (categoryService.updateCate(category)) {
            model.addAttribute("category", category);
            return "redirect:/category";
        } else {
            return "category/add";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        categoryService.deleteCate(id);
        redirectAttributes.addFlashAttribute("success","xoa thanh cong");
        return "redirect:/category";
    }
}
