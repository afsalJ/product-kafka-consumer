package com.afsal.project2_consumer.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoggerConfig {
    @Bean
    public Logger getLogger(){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();

        encoder.setContext(loggerContext);
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n");
        encoder.start();

        FileAppender fileAppender = new FileAppender();
        fileAppender.setEncoder(encoder);
        fileAppender.setFile("logs/application.logs");
        fileAppender.setName("FileLogger");
        fileAppender.setContext(loggerContext);
        fileAppender.start();

        ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.setAdditive(false);
        rootLogger.addAppender(fileAppender);

        return rootLogger;
    }
}
