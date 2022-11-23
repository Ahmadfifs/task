package com.ahmad.task;

import com.ahmad.task.modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			User user = User.of(null, "a@a.com", "0500000000", "Ahmad", 30);
			user = userRepository.save(user);
			Appointment appointment = Appointment.of(null, user, LocalDateTime.of(2022, Month.NOVEMBER, 23, 23, 0), AppointmentStatus.Under_Progress, null);
			appointmentRepository.save(appointment);
		};
	}

}
