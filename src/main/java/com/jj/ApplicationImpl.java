package com.jj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ApplicationImpl implements CommandLineRunner {
    private static final Logger LOG = LogManager.getLogger(ApplicationImpl.class);
    @Resource
    private IProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationImpl.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.debug("Inside main app runner, calling prod service in a loop now");
        for (int i = 0; i < 10; i++) {
            List<Product> products = productService.getAllProducts();
            LOG.info("Iteration {}: Received {} products", i + 1, products.size());
            TimeUnit.SECONDS.sleep(5);
        }
        LOG.debug("Exiting, good bye!!!");
    }
}
