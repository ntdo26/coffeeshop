package com.interview.coffeeshop.shop.entity;

import com.interview.coffeeshop.brand.dto.Brand;
import com.interview.coffeeshop.brand.entity.BrandEntity;
import com.interview.coffeeshop.menu.entity.DrinkEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity(name = "shop")
@Table
@Data
@NoArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String tenant;

    @Column(nullable = false, unique = true)
    private String location;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private int numberOfQueues;

    @Column(nullable = false)
    private int maximumSizeOfQueues;

    @Column(nullable = false)
    private int openingTime;

    @Column(nullable = false)
    private int closeTime;

    @OneToMany(mappedBy = "shop")
    private List<DrinkEntity> menu;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    private BrandEntity brand;

    @Column
    private Boolean isClosed;

}
