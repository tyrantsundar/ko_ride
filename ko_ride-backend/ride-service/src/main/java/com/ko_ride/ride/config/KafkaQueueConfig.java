package com.ko_ride.ride.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.kafka.core.*;
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.Map;

@Configuration
public class KafkaQueueConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    private String transactionPrefix = "ko_ride-local";
    int concurrencyThreads = 10;
    int deliveryTimeout = 120000;
    String requestTimeout = "30000";
    int retryBackOff = 5000;

    int exponentialBackOffMultiplier;
    int exponentialBackOffWithMaxReties;

    long initialInterval;
    int partitionValue;
    long pollTimeout;



//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> rideRequestedKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//

    @SuppressWarnings("deprecation")
    @Bean
    public ChainedKafkaTransactionManager<Object, Object> chainedKafkaTransactionManager(
            KafkaTransactionManager kafkaTransactionManager, MongoTransactionManager transactionManager) {
        return new ChainedKafkaTransactionManager<>(kafkaTransactionManager, transactionManager);
    }

    @Bean
    @Primary
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<String, String>(producerFactory);
        kafkaTemplate.setTransactionIdPrefix(transactionPrefix);
        return kafkaTemplate;
    }

    @Bean
    @Primary
    KafkaTransactionManager<String, String> kafkaTransactionManager(ProducerFactory<String, String> producerFactory) {
        return new KafkaTransactionManager<>(producerFactory);
    }

    @Bean
    public KafkaTemplate<String, String> nonTransactedKafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<String, String>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        var pf = new DefaultKafkaProducerFactory<String,String>(producerServerConfig(), new StringSerializer(),
                new StringSerializer());
        pf.setTransactionIdPrefix(transactionPrefix);
        return pf;
    }

    @Bean
    public Map<String, Object> producerServerConfig() {
        return Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, deliveryTimeout,
                ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeout,
                ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackOff,
                ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true",
                ProducerConfig.ACKS_CONFIG, "all");
    }

	@Bean
	public MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTransactionManager(mongoDatabaseFactory);
	}

}
