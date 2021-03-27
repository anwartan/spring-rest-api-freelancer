package com.freelancer.freelancer.entity;


import com.freelancer.freelancer.model.response.skill.SkillResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill extends BaseEntity{

    @Id
    @GenericGenerator(
            name = "skill-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "skill_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "skill-id-sequence-generator")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }

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

    public SkillResponse toResponse(){

        return new SkillResponse(this.id, this.name, this.getCreated_at(), this.getUpdated_at());
    }
}
