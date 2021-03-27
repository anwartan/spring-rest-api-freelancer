package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.entity.Category;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.model.request.category.CategoryRequest;
import com.freelancer.freelancer.model.response.category.CategoryResponse;
import com.freelancer.freelancer.repository.CategoryRepository;
import com.freelancer.freelancer.repository.SkillRepository;
import com.freelancer.freelancer.service.CategoryService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ValidationUtil validationUtil;
    public CategoryServiceImpl(CategoryRepository categoryRepository,ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        validationUtil.validate(categoryRequest);
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setCreated_at(new Date());
        category.setUpdated_at(new Date());

        categoryRepository.save(category);

        return category.toResponseWithSkill();
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) throws NotFoundException {
        Category category = findCategoryByIdOrElseThrow(id);

        validationUtil.validate(categoryRequest);

        category.setName(categoryRequest.getName());
        category.setUpdated_at(new Date());
        categoryRepository.save(category);
        return category.toResponseWithSkill();
    }

    @Override
    public CategoryResponse getById(Integer id) throws NotFoundException {
        Category category = findCategoryByIdOrElseThrow(id);
        return category.toResponseWithSkill();
    }


    @Override
    public CategoryResponse delete(Integer id) throws NotFoundException {
        Category category = findCategoryByIdOrElseThrow(id);

        categoryRepository.delete(category);
        return category.toResponseWithSkill();

    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> responses = new ArrayList<>();
        for (Category item:categories) {
            responses.add(item.toResponseWithSkill());
        }

        return responses;
    }

    private Category findCategoryByIdOrElseThrow(Integer id) throws NotFoundException{
        return categoryRepository.findById(id).orElseThrow(NotFoundException::new);
    }



}
