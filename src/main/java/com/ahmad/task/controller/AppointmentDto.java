package com.ahmad.task.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
	
	private Long userId;
	private Long appointmentId;
	private String reason;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC")
	private LocalDateTime appointmentTime;
	private String username;
	
	
}
