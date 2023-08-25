package com.avigail.coupons.entities;
import com.avigail.coupons.dto.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany (mappedBy ="category", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<CouponEntity> couponEntities;

    @Column (name = "name",unique = true,nullable = true)
    private String name;

    public CategoryEntity(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryEntity() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
