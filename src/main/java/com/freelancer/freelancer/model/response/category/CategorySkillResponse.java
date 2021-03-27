package com.freelancer.freelancer.model.response.category;

import com.freelancer.freelancer.entity.Skill;

import java.util.Date;
import java.util.Set;

public class CategorySkillResponse extends CategoryResponse {

    private Set<Skill> skills;

    public CategorySkillResponse(Integer id, String name, Date created_at, Date update_at, Set<Skill> skills) {
        super(id, name, created_at, update_at);
        this.skills = skills;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
