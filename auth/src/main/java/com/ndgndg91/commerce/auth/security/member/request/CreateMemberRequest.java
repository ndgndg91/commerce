package com.ndgndg91.commerce.auth.security.member.request;

import com.ndgndg91.commerce.auth.security.member.Member;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class CreateMemberRequest {
    private String userName;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void validate() {
        com.google.common.base.Preconditions.checkNotNull(userName);
        com.google.common.base.Preconditions.checkNotNull(email);
        com.google.common.base.Preconditions.checkNotNull(password);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }

    public Member toMember() {
        Member member = new Member();
        member.signUp(email, userName, password);
        return member;
    }
}
