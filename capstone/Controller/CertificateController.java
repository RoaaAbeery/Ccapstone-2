package com.example.capstone.Controller;

import com.example.capstone.Model.Certificate;
import com.example.capstone.Model.Language;
import com.example.capstone.Service.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/Certificate")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateService certificateService;
    @GetMapping("/getCertificate")
    public ResponseEntity getCertificate(){
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getCertificate());
    }
    @PostMapping("/addCertificate")
    public ResponseEntity addCertificate(@RequestBody @Valid Certificate certificate, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        certificateService.addCertificate(certificate);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate add");
    }
    @PutMapping("/updateCertificate/{id}")
    public ResponseEntity updateCertificate(@PathVariable Integer id,@RequestBody@Valid Certificate certificate,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        certificateService.updateCertificate(id, certificate);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate updated");
    }
    @DeleteMapping("/deleteCertificate/{id}")
    public ResponseEntity deleteCertificate(@PathVariable Integer id){
        certificateService.delteCertificate(id);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate deleted");
    }
    @GetMapping("/getDate/{start}/{end}")
    public ResponseEntity getDate(@PathVariable LocalDate start,@PathVariable LocalDate end){
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getDate(start, end));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity getByname(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getByName(name));
    }
}
