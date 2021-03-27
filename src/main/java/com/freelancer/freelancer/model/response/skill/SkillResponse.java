package com.freelancer.freelancer.model.response.skill;

import com.freelancer.freelancer.entity.Category;
import com.freelancer.freelancer.model.response.base.BaseResponse;

import java.util.Date;

public class SkillResponse extends BaseResponse {

    private Integer id;
    private String name;

    public SkillResponse(Integer id,String name, Date created_at, Date updated_at) {
        super(created_at, updated_at);
        this.name = name;
        this.id = id;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
