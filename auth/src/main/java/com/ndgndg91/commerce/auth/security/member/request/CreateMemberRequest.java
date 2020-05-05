package com.ndgndg91.commerce.auth.security.member.request;

import com.ndgndg91.commerce.auth.security.member.Member;
import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public final class CreateMemberRequest {
    private final String userName;
    private final String email;
    private final String password;

    public CreateMemberRequest(String userName, String email, String password) {
        com.google.common.base.Preconditions.checkNotNull(userName);
        com.google.common.base.Preconditions.checkNotNull(email);
        com.google.common.base.Preconditions.checkNotNull(password);
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Member toMember() {
        return Member.builder()
                .id(email)
                .userName(userName)
                .password(password)
                .build();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}
