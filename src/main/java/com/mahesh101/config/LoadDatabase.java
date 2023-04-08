package com.mahesh101.config;


import com.mahesh101.Repository.PatientRepository;
import com.mahesh101.Repository.ReportRepository;
import com.mahesh101.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    @Qualifier("cmdLineRunner")
    CommandLineRunner commandLineRunner(PatientRepository patientRepository, ReportRepository reportRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("preloading"+patientRepository.save(new Patient("mahesh","corona",84129756,"1st flower First bed","insurance")));
                log.info("preloading"+patientRepository.save(new Patient("SakShi","H3N2",567679756,"2st flower second bed","insurance")));
                log.info("preloading"+patientRepository.save(new Patient("TeJas","maleRia",353629756,"3st flower third bed","insurance")));



            }
        };
    }

}
