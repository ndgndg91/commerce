package com.ndgndg91.commerce.auth.security.member;


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
//    @Column(name = "memberNo")
    private long memberNo;

//    @Column(name = "memberUniqueKey")
    private String memberUniqueKey;
//    @Column(name = "userName")
    private String userName;
//    @Column(name = "certification")
    private String certification;
//    @Column(name = "password")
    private String password;
//    @Column(name = "signupForm")
    private String signupForm;
//    @Column(name = "signupKey")
    private String signupKey;
//    @Column(name = "plan")
    private String plan;
//    @Column(name = "campaing")
    private String campaing;
//    @Column(name = "adQuery")
    private String adQuery;
//    @Column(name = "adKeyword")
    private String adKeyword;
//    @Column(name = "status")
    private String status;
//    @Column(name = "emailSubscription")
    private String emailSubscription;
//    @Column(name = "showNotice")
    private boolean showNotice;
//    @Column(name = "billkey")
    private String billkey;
//    @Column(name = "billkeyInfo")
    private String billkeyInfo;
//    @Column(name = "paymentTerm")
    private int paymentTerm;
//    @Column(name = "cancel")
    private String cancel;
//    @Column(name = "loginCount")
    private long loginCount;
//    @Column(name = "editorStayTime")
    private long editorStayTime;
//    @Column(name = "editorPublishCount")
    private long editorPublishCount;
//    @Column(name = "loginDate")
    private LocalDateTime loginDate;
//    @Column(name = "updateDate")
    private LocalDateTime updateDate;
//    @Column(name = "joinedDate")
    private LocalDateTime joinedDate;
//    @Column(name = "expireDate")
    private LocalDateTime expireDate;
}
