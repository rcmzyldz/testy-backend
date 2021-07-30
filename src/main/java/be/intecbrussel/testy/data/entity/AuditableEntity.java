package be.intecbrussel.testy.data.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

// LOMBOK
@MappedSuperclass

// JPA
@EntityListeners(AuditingEntityListener.class)

public class AuditableEntity<U> {

    @CreatedBy
    @Column(name = "created_by")
    private
    U createdBy;

    @CreationTimestamp
    @Column(name = "created_date")
    private
    Timestamp createdAt;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private
    U updatedBy;

    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private
    Timestamp updatedAt;

    public AuditableEntity() {
    }

    protected U getCreatedBy() {
        return this.createdBy;
    }

    protected Timestamp getCreatedAt() {
        return this.createdAt;
    }

    protected U getUpdatedBy() {
        return this.updatedBy;
    }

    protected Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    protected void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    protected void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    protected void setUpdatedBy(U updatedBy) {
        this.updatedBy = updatedBy;
    }

    protected void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toString() {
        return "AuditableEntity(createdBy=" + this.getCreatedBy() + ", createdAt=" + this.getCreatedAt() + ", updatedBy=" + this.getUpdatedBy() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
