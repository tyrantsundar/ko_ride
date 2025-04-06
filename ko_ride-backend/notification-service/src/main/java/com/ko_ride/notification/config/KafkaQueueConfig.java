package com.ko_ride.notification.config;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.AfterRollbackProcessor;
import org.springframework.kafka.listener.DefaultAfterRollbackProcessor;
import org.springframework.kafka.support.ExponentialBackOffWithMaxRetries;
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager;
import org.springframework.kafka.transaction.KafkaTransactionManager;

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableKafka
public class KafkaQueueConfig {
//    private String bootstrapServers;
//    private String transactionPrefix = "ko_ride-local";
//    int concurrencyThreads = 10;
//    int deliveryTimeout = 120000;
//    String requestTimeout = "30000";
//    int retryBackOff = 5000;
//    long pollTimeout;
//    int exponentialBackOffMultiplier;
//    int exponentialBackOffWithMaxReties;
//    long initialInterval;
//    int partitionValue = 3;
//
////    @Bean
////    public Map<String, Object> producerServerConfig() {
////        return Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
////                ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, deliveryTimeout, ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,
////                requestTimeout, ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackOff,
////                ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true", ProducerConfig.ACKS_CONFIG, "all");
////    }
//
//    @Bean
//    public Map<String, Object> consumerServerConfig() {
//        return Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
//                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest", ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG,
//                requestTimeout, ConsumerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackOff,
//                ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 3, ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE,
//                ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
//    }
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerServerConfig(), new StringDeserializer(),
//                new StringDeserializer());
//    }
//
////    @Bean
////    public ProducerFactory<String, String> producerFactory() {
////        var pf = new DefaultKafkaProducerFactory<String, String>(producerServerConfig(), new StringSerializer(),
////                new StringSerializer());
////        pf.setTransactionIdPrefix(transactionPrefix);
////        return pf;
////    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<String, String> consumerFactory,
//            ChainedKafkaTransactionManager<Object, Object> chainedKafkaTransactionManager,
//            KafkaTemplate<String, String> kafkaTemplate) {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
////        factory.setAfterRollbackProcessor(errorLogProcessor(kafkaTemplate, customConsumerRecordRecoverer));
//        factory.setConcurrency(concurrencyThreads);
//        factory.getContainerProperties().setPollTimeout(pollTimeout);
////        factory.getContainerProperties().setTransactionManager(chainedKafkaTransactionManager);
//        factory.setConsumerFactory(consumerFactory);
//
//        return factory;
//    }
//
////    @Bean
////    public MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
////        return new MongoTransactionManager(mongoDatabaseFactory);
////    }
////
////    @Bean
////    public ChainedKafkaTransactionManager<Object, Object> chainedKafkaTransactionManager(
////            KafkaTransactionManager<String, String> kafkaTransactionManager,
////            MongoTransactionManager transactionManager) {
////        return new ChainedKafkaTransactionManager<>(kafkaTransactionManager, transactionManager);
////    }
//
//    @Bean
//    @Primary
//    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
//        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
//        kafkaTemplate.setTransactionIdPrefix(transactionPrefix);
//        return kafkaTemplate;
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> nonTransactedKafkaTemplate(ProducerFactory<String, String> producerFactory) {
//        return new KafkaTemplate<>(producerFactory);
//    }
//
//    @Bean
//    @Primary
//    KafkaTransactionManager<String, String> kafkaTransactionManager(ProducerFactory<String, String> producerFactory) {
//        return new KafkaTransactionManager<>(producerFactory);
//    }

//    @Bean
//    AfterRollbackProcessor<Object, Object> errorLogProcessor(KafkaTemplate<String, String> kafkaTemplate,
//                                                             CustomConsumerRecordRecoverer customConsumerRecordRecoverer) {
//        final ExponentialBackOffWithMaxRetries backOffPolicy = new ExponentialBackOffWithMaxRetries(
//                exponentialBackOffWithMaxReties);
//        backOffPolicy.setMultiplier(exponentialBackOffMultiplier);
//        backOffPolicy.setInitialInterval(initialInterval);
//        DefaultAfterRollbackProcessor defaultAfterRollbackProcessor = new DefaultAfterRollbackProcessor<>(
//                customConsumerRecordRecoverer, backOffPolicy, kafkaTemplate, true);
//        return defaultAfterRollbackProcessor;
//    }
}
