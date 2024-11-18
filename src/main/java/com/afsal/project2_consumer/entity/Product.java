package com.afsal.project2_consumer.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="Product", uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id", "skuCode"})})
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Column(name="skuCode", nullable = false)
    private String skuCode;

    @Column(name = "name", nullable = false)
    private String name;

    @UpdateTimestamp
    @Column(name = "last_modified_date" , nullable = false)
    private Timestamp last_modified_date;

    @Column(name = "enable", nullable = false)
    private Boolean enable;

    public Product(int clientId, Employee employee, String skuCode, String name,  Boolean enable) {
        this.clientId = clientId;
        this.employee = employee;
        this.skuCode = skuCode;
        this.name = name;
        this.enable = enable;
    }
}
