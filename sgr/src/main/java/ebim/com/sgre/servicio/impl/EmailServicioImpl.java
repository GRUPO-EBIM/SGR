package ebim.com.sgre.servicio.impl;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ebim.com.sgre.servicio.EmailServicio;

@Service
public class EmailServicioImpl implements EmailServicio{
	
	@Autowired
    public JavaMailSender emailSender;
	
	public void enviarMensajeCorreo(
			String de,
			String para, 
			String asunto, 
			String texto) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
	    	helper.setFrom(de);
		    helper.setTo(para);
		    helper.setSubject(asunto);
		    helper.setText(texto,true);
		    
	        emailSender.send(message);
	        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void enviarMensajeCorreoAdjunto(
			String de,
			String para, 
			String asunto, 
			String texto,
			File adjunto) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
	    	helper.setFrom(de);
		    helper.setTo(para);
		    helper.setSubject(asunto);
		    helper.setText(texto,true);
		    helper.addAttachment(adjunto.getName(), adjunto);
		    
	        emailSender.send(message);
	        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void enviarMensajeCorreoVariosAdjunto(
			String de,
			String para, 
			String asunto, 
			String texto,
			List<String> lstNFile) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
	    	helper.setFrom(de);
		    helper.setTo(para);
		    helper.setSubject(asunto);
		    helper.setText(texto,true);
		    
		    for(int i=0; i<lstNFile.size(); i++) {
		    	File convFile = new File(lstNFile.get(i));
		    	helper.addAttachment(convFile.getName(), convFile);
			}
		    
	        emailSender.send(message);
	        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
