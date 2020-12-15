package com.parkgw.apis.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_Id;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 12)
    private String phone;

    @Builder
    public User(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public User() {

    }

    @Override
    public String toString() {
        return String.format(
                "User[user_Id=%d, email='%s', name='%s', phone='%s']",
                this.user_Id, this.email, this.name, this.phone
        );
    }
}
