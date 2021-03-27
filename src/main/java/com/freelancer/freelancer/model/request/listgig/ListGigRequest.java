package com.freelancer.freelancer.model.request.listgig;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freelancer.freelancer.model.request.base.BaseRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ListGigRequest extends BaseRequest {
    @NotNull
    @JsonProperty("list_id")
    @Min(value = 1)
    private Integer listId;

    @NotNull
    @JsonProperty("gig_id")
    @Min(value = 1)
    private Integer gigId;

    public Integer getListId() {
        return listId;
    }

    public Integer getGigId() {
        return gigId;
    }
}
