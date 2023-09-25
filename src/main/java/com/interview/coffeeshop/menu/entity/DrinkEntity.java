package com.interview.coffeeshop.menu.entity;

import com.interview.coffeeshop.shop.entity.ShopEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "drink")
@Table
@Data
public class DrinkEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private String tenant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column
    private Integer discountByPercent;

    @Column
    private Boolean isOutOfStock;

    @Column(nullable = false)
    private int minutesForPreparing;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "shopId", referencedColumnName = "id")
    private ShopEntity shop;

    public int discountedPrice() {
        Integer price = Integer.valueOf(this.price);
        return price - (price * this.discountByPercent / 100);
    }

}
