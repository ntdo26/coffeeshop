package com.interview.coffeeshop.order.entity;

import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.queue.entity.QueueEntity;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import com.interview.coffeeshop.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "order_transaction")
@Table
@Data
public class OrderEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String tenant;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shopId", referencedColumnName = "id", nullable = false)
    private ShopEntity shop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drinkId", referencedColumnName = "id", nullable = false)
    private DrinkEntity drink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "order")
    private QueueEntity queue;

    @Column(nullable = false)
    private String price;
}
