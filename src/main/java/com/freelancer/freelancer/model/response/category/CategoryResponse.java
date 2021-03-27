package com.freelancer.freelancer.model.response.category;

import com.freelancer.freelancer.entity.Gig;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.model.response.base.BaseResponse;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CategoryResponse extends BaseResponse {

    public CategoryResponse(Integer id, String name, Date created_at, Date update_at) {
        super(created_at,update_at);
        this.id = id;
        this.name = name;
    }

    private Integer id;

    private String name;


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

}
