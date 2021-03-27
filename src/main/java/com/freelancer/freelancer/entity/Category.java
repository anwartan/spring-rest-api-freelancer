package com.freelancer.freelancer.entity;

import com.freelancer.freelancer.model.response.category.CategoryGigResponse;
import com.freelancer.freelancer.model.response.category.CategoryResponse;
import com.freelancer.freelancer.model.response.category.CategorySkillResponse;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    @GenericGenerator(
            name = "category-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "categories_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "category-id-sequence-generator")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "category")
    private Set<Gig> gigs = new HashSet<>();

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryResponse toResponse(){
        CategoryResponse categoryResponse = new CategoryResponse(this.id, this.getName(), this.getCreated_at(), this.getUpdated_at());
        return  categoryResponse;
    }

    public CategoryResponse toResponseWithSkill(){
        return  new CategorySkillResponse(this.id, this.getName(), this.getCreated_at(), this.getUpdated_at(),this.skills);
    }

    public CategoryResponse toResponseWithGig(){
        return  new CategoryGigResponse(this.id, this.getName(), this.getCreated_at(), this.getUpdated_at(),this.gigs);
    }
}
