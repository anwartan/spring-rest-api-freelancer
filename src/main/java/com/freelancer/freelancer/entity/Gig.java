package com.freelancer.freelancer.entity;

import com.freelancer.freelancer.model.response.gig.GigCategoryResponse;
import com.freelancer.freelancer.model.response.gig.GigResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gigs")
public class Gig extends BaseEntity {
    @Id
    @GenericGenerator(
            name = "gig-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "gigs_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "gig-id-sequence-generator")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "gig")
    private Set<ListGig> lists;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GigResponse toResponse(){

        return new GigResponse(this.id, this.getName(), this.getCreated_at(), this.getUpdated_at());
    }

    public GigResponse toResponseWithCategory(){

        return new GigCategoryResponse(this.id, this.getName(), this.getCreated_at(), this.getUpdated_at(),this.category);
    }




}
