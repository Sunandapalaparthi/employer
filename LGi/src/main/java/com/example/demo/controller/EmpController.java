package com.example.demo.controller;

import java.util.Calendar;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmpRegistration;
import com.example.demo.repository.EmpRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/employer")
public class EmpController {
@Autowired
 private EmpRepository  er;
@Autowired
public JavaMailSender javaMailSender;

@PostMapping("/emp")
public EmpRegistration empr(@RequestBody EmpRegistration empr) {
	EmpRegistration empregistartion=er.save(new EmpRegistration( empr.getFirstname(),empr.getOfficialemail(),
			empr.getMobilenumber(),empr.getRefferedpersonname(),empr.getEmail(),empr.getPhonenumber()));
	return empregistartion;
	
}

@GetMapping("/empget")
public EmpRegistration  empget(@PathVariable("id") Long id) {
Optional<EmpRegistration> empget=er.findById(id);
return empget.get();
}
@PutMapping("/empedit")
public ResponseEntity<String> empedit(@PathVariable("id") Long id,@RequestBody EmpRegistration empr){
	Optional<EmpRegistration> empedit=er.findById(id);
	if(empedit.isPresent()) {
		EmpRegistration e=empedit.get();
		e.setFirstname(empr.getFirstname());
		e.setOfficialemail(empr.getOfficialemail());
		e.setMobilenumber(empr.getMobilenumber());
		e.setRefferedpersonname(empr.getRefferedpersonname());
		e.setEmail(empr.getEmail());
		er.save(e);
		return ResponseEntity.ok().body("updated successfully");
	}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PostMapping("/forgotpassword")
public ResponseEntity<String>employerRegistartion(@Valid @RequestBody EmpRegistration empr){
	SimpleMailMessage message = new SimpleMailMessage();
	if(er.existsByEmail(empr.getEmail())) {
		message.setTo(empr.getEmail());
		message.setSubject("simple mail sender");
		message.setText("hi how r u"+"https://www.google.com/search?q=dynamic+registration+from&rlz=1C1SQJL_enIN849IN849&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiO57DfzsLiAhWJeisKHUL9AWQQ_AUIDigB&biw=1366&bih=657#imgrc=oTlBMiL0jJFPbM:");
		
	
javaMailSender.send(message);
		return new ResponseEntity<String>("email exits successfully", HttpStatus.FOUND);
		}		
	return ResponseEntity.ok().body("invalid email, please enter correct email address");
}

}