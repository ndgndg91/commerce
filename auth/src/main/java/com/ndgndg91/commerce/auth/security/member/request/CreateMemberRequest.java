package com.ndgndg91.commerce.auth.security.member.request;

import com.ndgndg91.commerce.auth.security.member.Email;
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
        com.google.common.base.Preconditions.checkNotNull(userName, "userName 은 필수입니다.");
        com.google.common.base.Preconditions.checkNotNull(email, "email 은 필수입니다.");
        com.google.common.base.Preconditions.checkNotNull(password, "password 는 필수입니다.");
        com.google.common.base.Preconditions.checkArgument(userName.length() > 50, "userName 길이는 최대 50자 입니다.");
        com.google.common.base.Preconditions.checkArgument(Email.checkAddress(email), "이메일 형식이 아닙니다.");
        com.google.common.base.Preconditions.checkArgument(email.length() > 100, "이메일이 너무 깁니다.");
        com.google.common.base.Preconditions.checkArgument(password.length() > 4 && password.length() < 30, "비밀번호는 4~30 자리입니다.");
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
