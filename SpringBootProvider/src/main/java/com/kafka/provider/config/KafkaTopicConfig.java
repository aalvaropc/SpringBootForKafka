package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic generatTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "85000000");
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000000");

        return TopicBuilder.name("test-topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
