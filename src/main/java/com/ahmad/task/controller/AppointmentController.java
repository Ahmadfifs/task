package com.ahmad.task.controller;

import com.ahmad.task.modal.Appointment;
import com.ahmad.task.modal.UserRepository;
import com.ahmad.task.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public ResponseEntity<?> getAllAppointment(@PageableDefault Pageable pageable){
		return ResponseEntity.ok(appointmentService.getAllAppointment(pageable));
	}
	
	@PostMapping
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto){
		return ResponseEntity.ok(appointmentService.createAppointment(appointmentDto));
	}
	
	@PutMapping
	public ResponseEntity<?> cancelAppointment(@RequestBody AppointmentDto appointmentDto){
		return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentDto));
	}
	
	@PostMapping("/filter/date")
	public ResponseEntity<?> getAppointmentsByDate(@PageableDefault Pageable pageable, @RequestBody AppointmentDto appointmentDto){
		return ResponseEntity.ok(appointmentService.getAppointmentByDate(pageable, appointmentDto));
	}
	
	@GetMapping("/filter/user")
	public ResponseEntity<?> getAppointmentByUserName(@PageableDefault Pageable pageable, @RequestParam String username){
		return ResponseEntity.ok(appointmentService.getAppointmentByUsername(pageable, username));
	}
	
	@GetMapping("/history/{id}")
	public ResponseEntity<?> getAppointmentByUserId(@PageableDefault Pageable pageable, @PathVariable Long id){
		return ResponseEntity.ok(appointmentService.getAppointmentByUserId(pageable, id));
	}
	
}
