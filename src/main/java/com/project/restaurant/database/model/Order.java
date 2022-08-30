package com.project.restaurant.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private Double favoriteDelivery;

    @Column(nullable = false)
    private Double totalPrice;


    @Column(nullable = false, length = 100)
    private String paymentType;


    @Column(nullable = false, length = 100)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private OrderStatus status;


    @Column(nullable = false)
    private Long userIdGet;

    @Column(nullable = false, length = 100)
    private String nameGet;

    @Column(nullable = false, length = 100)
    private String emailGet;

    @Column(nullable = false, length = 100)
    private String addressGet;

    @Column(nullable = false, length = 100)
    private String phoneGet;


    @OneToMany(
            targetEntity = Item.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "orderIdFk",
            referencedColumnName = "orderId")
    private List<Item> items = new ArrayList<>();
}
