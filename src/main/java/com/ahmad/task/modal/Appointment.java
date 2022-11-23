package com.ahmad.task.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@ToString
@Table(name = "APPOINTMENT")
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Appointment {
	
	public interface AppointmentView {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER", nullable = false)
	private User patient;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC")
	private LocalDateTime time;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
	
	
	private String reason;
	
}
