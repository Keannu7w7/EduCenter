package com.matt.EduCenter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.matt.EduCenter.Modelo.*;
import com.matt.EduCenter.repository.*;
import java.time.LocalDate;


@SpringBootApplication
public class EduCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduCenterApplication.class, args);
    }


}

