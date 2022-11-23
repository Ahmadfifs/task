package com.ahmad.task.modal;


import com.sun.xml.bind.v2.schemagen.episode.Package;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	Page<Appointment> findAllByTime(Pageable pageable, LocalDateTime time);
	
	Page<Appointment> findAllByPatient(Pageable pageable, User user);
	
	
}
