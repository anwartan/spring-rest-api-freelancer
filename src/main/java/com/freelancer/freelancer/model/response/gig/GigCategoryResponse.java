package com.freelancer.freelancer.model.response.gig;

import com.freelancer.freelancer.entity.Category;

import java.util.Date;

public class GigCategoryResponse extends GigResponse {

    private Category category;

    public GigCategoryResponse(Integer id, String name, Date created_at, Date updated_at, Category category) {
        super(id, name, created_at, updated_at);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
