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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users" )
public class UserEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_product",
            joinColumns = @JoinColumn(name = "userid",referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "productid",referencedColumnName = "product_id"))
   // @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductEntity> products;

    public UserEntity(int id, String name, String mail) {
             this.userId=id;
             this.userName=name;
             this.email=mail;

    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
