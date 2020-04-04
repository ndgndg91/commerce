package com.ndgndg91.commerce.auth.security.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ApiSuccessResult {

    @Getter
    @JsonUnwrapped
    private Object body;

    private ApiSuccessResult(){}

    public static ApiSuccessResult wrap(Object body) {
        ApiSuccessResult result = new ApiSuccessResult();
        result.body = body;
        return result;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}
