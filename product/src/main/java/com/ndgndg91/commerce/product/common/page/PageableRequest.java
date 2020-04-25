package com.ndgndg91.commerce.product.common.page;


public class PageableRequest implements Pageable {
    private final int offset;

    private final int limit;

    public PageableRequest() {
        this(0, 5);
    }

    public PageableRequest(int offset, int limit) {
        if (offset < 0)
            throw new IllegalArgumentException("Offset must be greater or equals zero.");
        if (limit < 1)
            throw new IllegalArgumentException("Limit must be greater than zero.");

        this.offset = offset;
        this.limit = limit;
    }


    @Override
    public int offset() {
        return offset;
    }

    @Override
    public int limit() {
        return limit;
    }
}
