package com.ndgndg91.commerce.auth.security.member.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ndgndg91.commerce.auth.security.member.Member;
import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MemberToFront {
    private long memberNo;
    private String id;
    private String userName;
    private String plan;

    public static MemberToFront transform(Member member){
        MemberToFront res = new MemberToFront();
        res.memberNo = member.getMemberNo();
        res.id = member.getId();
        res.userName = member.getUserName();
        res.plan = member.getPlan();
        return res;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}
