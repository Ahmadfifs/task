package com.ahmad.task.service;


import com.ahmad.task.controller.AppointmentDto;
import com.ahmad.task.modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Page<Appointment> getAllAppointment(Pageable pageable){
		return appointmentRepository.findAll(pageable);
	}
	
	public Appointment createAppointment(AppointmentDto appointmentDto){
		User user = userRepository.findById(appointmentDto.getUserId())
				            .orElseThrow(() -> new IllegalArgumentException("there is no user"));
		if (LocalDateTime.now().isAfter(appointmentDto.getAppointmentTime())) throw new IllegalArgumentException("the date should be before current date");
		Appointment appointment = Appointment.of(null, user, appointmentDto.getAppointmentTime(), AppointmentStatus.Under_Progress, null);
		return appointmentRepository.save(appointment);
		
	}
	
	
	public Appointment cancelAppointment(AppointmentDto appointmentDto){
		Appointment appointment = appointmentRepository.findById(appointmentDto.getAppointmentId())
				                          .orElseThrow(() -> new IllegalArgumentException("there is no appointment"));
		appointment.setStatus(AppointmentStatus.Canceled);
		appointment.setReason(appointmentDto.getReason());
		return appointmentRepository.save(appointment);
	}
	
	
	public Page<Appointment> getAppointmentByDate(Pageable pageable, AppointmentDto appointmentDto){
		return appointmentRepository.findAllByTime(pageable, appointmentDto.getAppointmentTime());
	}
	
	
	public Page<Appointment> getAppointmentByUsername(Pageable pageable, String username){
		User user = userRepository.findByName(username)
				            .orElseThrow(() -> new IllegalArgumentException("there is no user with this name"));
		return appointmentRepository.findAllByPatient(pageable, user);
	}
	
	public Page<Appointment> getAppointmentByUserId(Pageable pageable, Long id){
		User user = userRepository.findById(id)
				            .orElseThrow(() -> new IllegalArgumentException("there is no user with this id"));
		return appointmentRepository.findAllByPatient(pageable, user);
	}
}
