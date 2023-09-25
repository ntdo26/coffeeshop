package com.interview.coffeeshop.brand.entity;

import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity(name = "brand")
@Table
@Data
@NoArgsConstructor
@ToString
public class BrandEntity {

    public BrandEntity(String code, String shopName) {
        this.name = shopName;
        this.code = code;
    }

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<ShopEntity> shops;

}
