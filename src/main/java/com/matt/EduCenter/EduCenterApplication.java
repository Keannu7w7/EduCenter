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
 /*   @Bean
    CommandLineRunner initData(UserRepository userRepository,CursoRepository cursoRepository,InscripcionRepository inscripcionRepository){
        return args -> {
            User admin1 = new User();
            admin1.setNombre("Mateo");
            admin1.setApellido("Villacis");
            admin1.setCedula("1850253889");
            admin1.setEmail("mateo2021.tablet1@gmail.com");
            admin1.setPassword("1234");
            admin1.setFechaNacimiento(LocalDate.of(2007,3,26));
            admin1.setRol(Rol.ADMIN);
            userRepository.save(admin1);
            //---------------------------------------------------------------------------------//

            User prof1 = new User();
            prof1.setApellido("Guevara");
            prof1.setNombre("Abraham");
            prof1.setCedula("0000000002");
            prof1.setEmail("profe@edu.com");
            prof1.setPassword("4321");
            prof1.setFechaNacimiento(LocalDate.of(1985,3,28));
            prof1.setRol(Rol.PROFESOR);
            userRepository.save(prof1);

            //------------------------------------------------------------------------------//

            User estuTest = new User();
            estuTest.setNombre("Ana");
            estuTest.setApellido("Estudiante");
            estuTest.setCedula("0000000003");
            estuTest.setEmail("estudiante@edu.com");
            estuTest.setPassword("3224");
            estuTest.setFechaNacimiento(LocalDate.of(2005, 8, 15));
            estuTest.setRol(Rol.ESTUDIANTE);
            userRepository.save(estuTest);

            //-------------------------------------------------------------------//

            Curso curso1= new Curso();
            curso1.setNombre("Calculo");
            curso1.setDescription("Curso avazado de Calculo diferencial e Integral");
            curso1.setProfesor(prof1);

            cursoRepository.save(curso1);

            //-------------------------------------------------------------------//

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEstudiante(estuTest);
            inscripcion.setCurso(curso1);
            inscripcion.setFechaInscripcion(LocalDate.now());

            inscripcionRepository.save(inscripcion);

            System.out.println("DATOS INICIALES CREADOS");

        };
    }*/


}

