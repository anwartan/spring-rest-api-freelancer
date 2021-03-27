package com.freelancer.freelancer.entity;


import com.freelancer.freelancer.model.response.listgig.ListGigResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ListGig extends BaseEntity {
    @Id
    @GenericGenerator(
            name = "listgig-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "listgig_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "listgig-id-sequence-generator")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private List list;

    @ManyToOne
    @JoinColumn(name = "gig_id")
    private Gig gig;



    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Gig getGig() {
        return gig;
    }

    public void setGig(Gig gig) {
        this.gig = gig;
    }

    public ListGigResponse toResponse(){

        return new ListGigResponse(this.id, this.list.toResponse(), this.gig.toResponse(),this.getCreated_at(), this.getUpdated_at());
    }
}
