package com.fincore.fincoregenesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ユーザー名を入力してください")                   // 定義の追加7/26追加
    @Size(max = 50, message = "ユーザー名は50文字以内で入力してください")
    @Column(nullable = false, length = 50)
    private String username;

    @NotBlank(message = "パスワードを入力してください")                   //定義の追加7/26追加
    @Size(min = 8, max = 255,
            message = "パスワードは8文字以上255文字以内で入力してください")
    @Column(nullable = false, length = 255)
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
