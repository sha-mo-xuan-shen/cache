package com.cache.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class XMemcached {

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        XMemcachedClientBuilder builder = new XMemcachedClientBuilder("localhost:11211");
        MemcachedClient client = builder.build();
        return client;
    }
}
