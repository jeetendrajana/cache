package com.jj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.jj.ProductLookup.INSTANCE;
import static java.time.Duration.ofSeconds;

@Service
public class ProductService implements IProductService {
    private static final Logger LOG = LogManager.getLogger(ProductService.class);

    private final AsyncCacheWrapper<String, List<Product>> cacheWrapper;

    public ProductService() {
        cacheWrapper = new AsyncCacheWrapper<>(INSTANCE, 1, 1, ofSeconds(15));
    }

    @Override
    public List<Product> getAllProducts() throws ExecutionException, InterruptedException {
        LOG.info("Getting all products from cache");
        return cacheWrapper.get("ALL_PRODUCTS");
    }
}
