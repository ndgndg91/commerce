package com.ndgndg91.commerce.auth.security.member;


import com.ndgndg91.commerce.auth.security.member.exception.InvalidPasswordException;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "members")
public class Member {

    @Id
    private long memberNo;
    private String memberUniqueKey;
    private String id;
    private String userName;
    private String certification;
    private String password;
    private String signupForm;
    private String signupKey;
    private String plan;
    private String campaing;
    private String adQuery;
    private String adKeyword;
    private String status;
    private String emailSubscription;
    private boolean showNotice;
    private String billkey;
    private String billkeyInfo;
    private int paymentTerm;
    private String cancel;
    private long loginCount;
    private long editorStayTime;
    private long editorPublishCount;
    private LocalDateTime loginDate;
    private LocalDateTime updateDate;
    private LocalDateTime joinedDate;
    private LocalDateTime expireDate;

    public void checkPassword(String credentials) {
        if (credentials.equals(password))
            return;

        throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
    }
}
