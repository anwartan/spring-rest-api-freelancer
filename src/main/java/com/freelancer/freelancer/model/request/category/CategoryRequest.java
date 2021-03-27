package com.freelancer.freelancer.model.request.category;

import com.freelancer.freelancer.model.request.base.BaseRequest;

import javax.validation.constraints.NotBlank;

public class CategoryRequest extends BaseRequest {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
