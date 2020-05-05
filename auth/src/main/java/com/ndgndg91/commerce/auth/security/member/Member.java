package com.ndgndg91.commerce.auth.security.member;


import com.ndgndg91.commerce.auth.security.member.exception.InvalidPasswordException;
import com.ndgndg91.commerce.auth.security.security.JWT;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberSeqGen")
    @SequenceGenerator(name = "memberSeqGen", sequenceName="MEMBER_ID_SEQ", allocationSize=20)
    private long memberNo;
    private String id;
    private String userName;
    private String password;
    private long loginCount;
    private LocalDateTime loginDate;
    private LocalDateTime updateDate;
    private LocalDateTime joinedDate;

    public void checkPassword(PasswordEncoder passwordEncoder, String credentials) {
        if (passwordEncoder.matches(credentials, password)) {
            return;
        }

        throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
    }

    public String newApiToken(JWT jwt, String[] roles) {
        JWT.Claims claims = JWT.Claims.of(memberNo, userName, new Email(id), roles);
        return jwt.newToken(claims);
    }

    public void omitPassword() {
        this.password = null;
    }

    public void increaseLoginCount() {
        this.loginCount++;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
