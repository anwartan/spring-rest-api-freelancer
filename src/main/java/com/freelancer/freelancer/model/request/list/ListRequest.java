package com.freelancer.freelancer.model.request.list;

import com.freelancer.freelancer.model.request.base.BaseRequest;

import javax.validation.constraints.NotBlank;

public class ListRequest extends BaseRequest {

    @NotBlank
    private String name;

    private String description;

    private Integer userId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
