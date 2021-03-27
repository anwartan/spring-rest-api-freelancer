package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.request.category.CategoryRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.category.CategoryResponse;
import com.freelancer.freelancer.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController extends BaseController {

    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(
            value = "/api/category",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest body) throws NotFoundException  {
        CategoryResponse categoryResponse = categoryService.create(body);
        return sendResponse(categoryResponse);

    }

    @GetMapping(
            value = "/api/category/all",
            produces = "application/json"
    )
    public WebResponse<List<CategoryResponse>> getAllCategory() {
        List<CategoryResponse> categoryResponse = categoryService.getAll();
        return sendResponse(categoryResponse);

    }
    @GetMapping(
            value = "/api/category/{idCategory}",
            produces = "application/json"
    )
    public WebResponse<CategoryResponse> getCategory(@PathVariable("idCategory") Integer id) throws NotFoundException {
        CategoryResponse categoryResponse = categoryService.getById(id);
        return sendResponse(categoryResponse);

    }

    @PutMapping(
            value = "/api/category/{idCategory}",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<CategoryResponse> updateCategory(@PathVariable("idCategory") Integer id, @RequestBody CategoryRequest body) throws NotFoundException {
        CategoryResponse categoryResponse = categoryService.update(body,id);
        return sendResponse(categoryResponse);

    }

    @DeleteMapping(
            value = "/api/category/{idCategory}",
            produces = "application/json"
    )
    public WebResponse<CategoryResponse> deleteCategory(@PathVariable("idCategory") Integer id) throws NotFoundException {
        CategoryResponse categoryResponse = categoryService.delete(id);
        return sendResponse(categoryResponse);

    }





}
