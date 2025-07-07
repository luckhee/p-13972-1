package com.back.domain.member.member.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member extends BaseEntity {
    @Column(unique = true)
    private String userName;
    private String password;
    private String nickname;

    @Column(unique = true)
    private String apiKey;

    public String getName() {
        return nickname;
    }

    public Member(String username, String password, String nickname) {
        this.userName = username;
        this.password = password;
        this.nickname = nickname;
        this.apiKey = UUID.randomUUID().toString();
    }
}
