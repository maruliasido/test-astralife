package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.Title;
import com.maruliastra.maruli.domain.entities.embbedId.TitleId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TitleRepository extends BaseRepository <Title, TitleId>{

    public TitleRepository(EntityManager em) {
        super(Title.class, em);
    }

}
