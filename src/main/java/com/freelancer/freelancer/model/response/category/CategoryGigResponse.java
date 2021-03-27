package com.freelancer.freelancer.model.response.category;

import com.freelancer.freelancer.entity.Gig;

import java.util.Date;
import java.util.Set;

public class CategoryGigResponse extends CategoryResponse {

    private Set<Gig> gigs;

    public CategoryGigResponse(Integer id, String name, Date created_at, Date update_at, Set<Gig> gigs) {
        super(id, name, created_at, update_at);
        this.gigs = gigs;
    }

    public Set<Gig> getGigs() {
        return gigs;
    }

    public void setGigs(Set<Gig> gigs) {
        this.gigs = gigs;
    }
}
