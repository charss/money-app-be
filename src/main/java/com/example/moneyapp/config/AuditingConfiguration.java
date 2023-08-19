//package com.example.moneyapp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.auditing.DateTimeProvider;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//import javax.swing.text.html.Option;
//import java.time.Instant;
//import java.time.OffsetDateTime;
//import java.time.ZoneId;
//import java.time.ZoneOffset;
//import java.util.Date;
//import java.util.Optional;
//
//@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider", dateTimeProviderRef = "auditingDateTimeProvider")
//public class AuditingConfiguration {
//    @Bean(name = "auditingDateTimeProvider")
//    public DateTimeProvider dateTimeProvider() {
//        return () -> Optional.of(OffsetDateTime.now());
////        OffsetDateTime auditDate = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
////        Date date = Date.from(auditDate.toInstant());
////
////        return () -> Optional.of(date.toInstant());
//    }
//
//
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        return Optional::empty;
//    }
//}
