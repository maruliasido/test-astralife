package com.maruliastra.maruli.base;

import com.maruliastra.maruli.utils.ConstantUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
public class BaseEntity {

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "user_create")
    private String userCreate;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "user_modify")
    private String userModify;

    @Column(name = "modification_time")
    private Date modificationTime;

    @PrePersist
    private void prePersist() {
        Date currentDateTime = new Date();
        this.userCreate = ConstantUtil.ANONYOMUS;
        this.creationTime = currentDateTime;
        this.userModify = ConstantUtil.ANONYOMUS;
        this.modificationTime = currentDateTime;
    }

    @PreUpdate
    private void preUpdate() {
        Date currentDateTime = new Date();

        this.userModify = ConstantUtil.ANONYOMUS;
        this.modificationTime = currentDateTime;
    }

}
