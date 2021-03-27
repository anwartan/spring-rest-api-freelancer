package com.freelancer.freelancer.model.response.listgig;

import com.freelancer.freelancer.entity.Gig;
import com.freelancer.freelancer.entity.List;
import com.freelancer.freelancer.model.response.base.BaseResponse;
import com.freelancer.freelancer.model.response.gig.GigResponse;
import com.freelancer.freelancer.model.response.list.ListResponse;

import java.util.Date;

public class ListGigResponse extends BaseResponse {

    private Integer id;

    private ListResponse list;

    private GigResponse gig;

    public ListGigResponse(Integer id, ListResponse list, GigResponse gig, Date created_at, Date updated_at ) {
        super(created_at, updated_at);
        this.id = id;
        this.list = list;
        this.gig = gig;
    }

    public Integer getId() {
        return id;
    }

    public ListResponse getList() {
        return list;
    }

    public GigResponse getGig() {
        return gig;
    }
}
