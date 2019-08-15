package com.jj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Function;

import static com.google.common.collect.Lists.newArrayList;

public enum ProductLookup implements Function<String, List<Product>> {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(ProductLookup.class);

    @Override
    public List<Product> apply(String s) {
        LOG.info("Getting all products from DB");
        return newArrayList(
                new Product(1L, "p1", "e1", "a1", "g1"),
                new Product(2L, "p2", "e1", "a1", "g1"),
                new Product(3L, "p3", "e2", "a2", "g2"),
                new Product(4L, "p4", "e2", "a2", "g2"),
                new Product(5L, "p5", "e3", "a3", "g3")
        );
    }
}
