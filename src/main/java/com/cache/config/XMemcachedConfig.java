package com.cache.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties properties;
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        XMemcachedClientBuilder builder = new XMemcachedClientBuilder(properties.getServers());
        builder.setConnectionPoolSize(properties.getPoolSize());
        builder.setOpTimeout(properties.getOpTimeout());
        MemcachedClient client = builder.build();
        return client;
    }
}
