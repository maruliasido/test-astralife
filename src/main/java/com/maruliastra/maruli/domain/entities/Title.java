package com.maruliastra.maruli.domain.entities;
import com.maruliastra.maruli.domain.entities.embbedId.TitleId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Table(name = "titles")
@Entity
public class Title {

    @EmbeddedId
    private TitleId titleId;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;



}
