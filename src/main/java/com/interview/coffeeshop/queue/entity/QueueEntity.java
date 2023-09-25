package com.interview.coffeeshop.queue.entity;

import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "queue")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String tenant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shopId", referencedColumnName = "id", nullable = false)
    private ShopEntity shop;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", referencedColumnName = "id", nullable = false)
    private OrderEntity order;

    @Column(nullable = false)
    private int position;
}
