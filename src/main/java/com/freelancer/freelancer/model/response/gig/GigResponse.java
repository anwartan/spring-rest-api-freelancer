package com.freelancer.freelancer.model.response.gig;

import com.freelancer.freelancer.model.response.base.BaseResponse;

import java.util.Date;

public class GigResponse extends BaseResponse {

    private Integer id;
    private String name;

    public GigResponse(Integer id, String name,Date created_at, Date updated_at) {
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
