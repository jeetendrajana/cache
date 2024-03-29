package com.jj;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * Intended to create one instance per data cache.
 * Abstracts the underlying cache implementation from the caller.
 *
 * @param <K>
 * @param <V>
 */
public class AsyncCacheWrapper<K, V> {
    private static final Logger LOG = LogManager.getLogger(AsyncCacheWrapper.class);

    private final AsyncCache<K, V> cache;
    private final Function<K, V> lookup;

    public AsyncCacheWrapper(Function<K, V> lookup, int initialCapacity, long maxSize, Duration refreshAfter) {
        LOG.debug("Creating cache with initial capacity {}, max size {}, refresh after {}", initialCapacity, maxSize, refreshAfter.toString());
        cache = Caffeine
                .newBuilder()
                .initialCapacity(initialCapacity)
                .maximumSize(maxSize)
                .refreshAfterWrite(refreshAfter)
                .buildAsync(lookup::apply);
        this.lookup = lookup;
    }

    public V get(K k) throws ExecutionException, InterruptedException {
        return cache.get(k, lookup).get();
    }
}
