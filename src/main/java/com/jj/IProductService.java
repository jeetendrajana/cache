package com.jj;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IProductService {
    List<Product> getAllProducts() throws ExecutionException, InterruptedException;
}
