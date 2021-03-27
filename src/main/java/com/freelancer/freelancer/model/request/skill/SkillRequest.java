package com.freelancer.freelancer.model.request.skill;

import com.freelancer.freelancer.model.request.base.BaseRequest;

public class SkillRequest extends BaseRequest {
    private Integer id;

    private String name;

    private Integer category_id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
