package com.freelancer.freelancer.model.response.list;

import com.freelancer.freelancer.model.response.base.BaseResponse;

import java.util.Date;

public class ListResponse extends BaseResponse {


    private Integer id;

    private String name;

    private String description;

    private Integer user_id;

    public ListResponse(Integer id,Integer user_id, String name, String description,Date created_at, Date updated_at) {
        super(created_at, updated_at);
        this.name= name;
        this.description = description;
        this.id = id;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUser_id() {
        return user_id;
    }


}
