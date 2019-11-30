package com.codenation.treinamento.job;

import com.codenation.treinamento.service.impl.CompanyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Slf4j
public class CompanyJob {
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @Scheduled(fixedRate = 5000000)
    public void getCompanyCount(){
        Instant iInicial = Instant.now();
        log.info("#### START VERIFY COUNT COMPANIES {}", iInicial.toString());
        log.info("#### FOUND {} COMPANY IN BASE",companyServiceImpl.getCompanyCount().toString());
        //Duration duration = Duration.between(iInicial, Instant.now());
        log.info("#### END VERIFY COUNT COMPANIES DURATION {} MILLISECONDS", Duration.between(iInicial, Instant.now()).toMillis());

    }
}
