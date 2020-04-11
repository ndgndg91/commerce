package com.ndgndg91.commerce.auth.security.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static com.ndgndg91.commerce.auth.security.member.MemberIdentifierType.USERNAME;

@RequiredArgsConstructor
public class UserName implements MemberIdentifier{
    @Getter
    private final String name;

    @Override
    public String getId() {
        return name;
    }

    @Override
    public MemberIdentifierType getType() {
        return USERNAME;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}
