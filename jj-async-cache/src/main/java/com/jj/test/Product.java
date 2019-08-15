package com.jj.test;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Product {
    private final Long productId;
    private final String name;
    private final String exchange;
    private final String asset;
    private final String productGroup;

    public Product(Long productId, String name, String exchange, String asset, String productGroup) {
        this.productId = productId;
        this.name = name;
        this.exchange = exchange;
        this.asset = asset;
        this.productGroup = productGroup;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getExchange() {
        return exchange;
    }

    public String getAsset() {
        return asset;
    }

    public String getProductGroup() {
        return productGroup;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
