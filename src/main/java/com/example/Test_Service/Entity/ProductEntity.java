package com.example.Test_Service.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity
{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="product_id")
    private Integer productId;
    @Column(name ="product_name")
    private String productName;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    List<UserEntity> users;


    public ProductEntity(int id, String productName) {
        this.productId = id;
        this.productName = productName;
    }
}
