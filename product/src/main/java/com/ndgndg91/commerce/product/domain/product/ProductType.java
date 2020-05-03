package com.ndgndg91.commerce.product.domain.product;

import java.util.Arrays;

public enum ProductType {
    BOOK("BookProduct", 1),
    CLOTHING("ClothingProduct", 2),
    ELECTRONICS("ElectronicsProduct", 3),
    FOOD("FoodProduct", 4);

    private final String serviceName;
    private final int codeValue;

    ProductType(String serviceName, int productCode) {
        this.serviceName = serviceName;
        this.codeValue = productCode;
    }

    public static String find(int codeValue) {
        return Arrays.stream(ProductType.values())
                .filter(productType -> productType.codeValue == codeValue)
                .findAny()
                .orElseThrow(IllegalArgumentException::new).serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
