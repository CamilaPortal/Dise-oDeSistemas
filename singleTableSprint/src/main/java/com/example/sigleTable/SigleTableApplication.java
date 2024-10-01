package com.example.sigleTable;

import com.example.sigleTable.entidades.Alumno;
import com.example.sigleTable.entidades.Profesor;
import com.example.sigleTable.enuneraciones.Especialidades;
import com.example.sigleTable.enuneraciones.Titulos;
import com.example.sigleTable.repositorios.AlumnoRepository;
import com.example.sigleTable.repositorios.PersonaRepository;
import com.example.sigleTable.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SigleTableApplication {


	private static final Logger logger = LoggerFactory.getLogger(SigleTableApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;
	public static void main(String[] args) {
		SpringApplication.run(SigleTableApplication.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Creo un objeto profesor
			Profesor prof1 = Profesor.builder()
					.nombre("Luis")
					.apellido("Perez")
					.fechaIngreso(LocalDate.of(2020, 5, 5))
					.cantHijos(1)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();

			Profesor prof2 = Profesor.builder()
					.nombre("María")
					.apellido("Rodriguez")
					.fechaIngreso(LocalDate.of(2021, 3, 15))
					.cantHijos(3)
					.titulo(Titulos.LICENCIADO)
					.sueldo(new BigDecimal("1500.00"))
					.build();

			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(prof1);
			profesorRepository.save(prof2);

			// Crear alumnos
			Alumno alum1 = Alumno.builder()
					.nombre("Jorge")
					.apellido("Fernández")
					.legajo(1001)
					.especialidad(Especialidades.BACHILLER)
					.build();

			Alumno alum2 = Alumno.builder()
					.nombre("Laura")
					.apellido("Rodríguez")
					.legajo(1002)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.build();

			// Guardar alumnos en la base de datos
			alumnoRepository.save(alum1);
			alumnoRepository.save(alum2);
			

		};

	};




}
