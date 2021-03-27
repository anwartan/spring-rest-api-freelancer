package com.freelancer.freelancer.entity;

import com.freelancer.freelancer.model.response.gig.GigResponse;
import com.freelancer.freelancer.model.response.list.ListResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lists")
public class List extends BaseEntity{
    @Id
    @GenericGenerator(
            name = "list-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "lists_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "list-id-sequence-generator")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @OneToMany(mappedBy = "list")
    private Set<ListGig> gigs;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListResponse toResponse(){

        return new ListResponse(this.id, this.user.getId(),this.name, this.description,this.getCreated_at(), this.getUpdated_at());
    }
}
