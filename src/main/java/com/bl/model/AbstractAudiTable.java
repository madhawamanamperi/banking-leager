package com.bl.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAudiTable {
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate = System.currentTimeMillis();

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate = System.currentTimeMillis();

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
}
