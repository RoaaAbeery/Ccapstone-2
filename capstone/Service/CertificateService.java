package com.example.capstone.Service;

import com.example.capstone.ApiException.ApiException;
import com.example.capstone.Model.Certificate;
import com.example.capstone.Model.Tutorial;
import com.example.capstone.Model.User;
import com.example.capstone.Repository.CertificateRepository;
import com.example.capstone.Repository.TutorialRepository;
import com.example.capstone.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;
    private final TutorialRepository tutorialRepository;
    public List<Certificate> getCertificate(){
        return certificateRepository.findAll();
    }
    public void addCertificate(Certificate certificate){
        User user=userRepository.findUsersById(certificate.getUser_id());
        Tutorial tutorial=tutorialRepository.findTutorialById(certificate.getTutorial_id());
        if(user==null){
            throw new ApiException("User id not found");
        }
        if(tutorial==null){
            throw new ApiException("Tutorial id not found");
        }
        certificateRepository.save(certificate);
    }
    public void updateCertificate(Integer id ,Certificate certificate){
        User user=userRepository.findUsersById(certificate.getUser_id());
        Tutorial tutorial=tutorialRepository.findTutorialById(certificate.getTutorial_id());
        Certificate oldcertificate=certificateRepository.findCertificateById(id);
        if(user==null){
            throw new ApiException("User id not found");
        }
        if(oldcertificate==null){
            throw new ApiException("Certificate id not found");
        }
        oldcertificate.setCertificate_name(certificate.getCertificate_name());
        oldcertificate.setCertificate_date(certificate.getCertificate_date());
        certificateRepository.save(oldcertificate);
    }
    public void delteCertificate(Integer id){
        Certificate certificate=certificateRepository.findCertificateById(id);
        if(certificate==null){
            throw new ApiException("Certificate id not found");
        }
        certificateRepository.delete(certificate);
    }
    public List<Certificate> getDate(LocalDate start,LocalDate end){
        List<Certificate> certificates=certificateRepository.findCertificatesInDateRange(start, end);
        if(certificates==null){
            throw new ApiException("not found");
        }
        return certificates;
    }
    public Certificate getByName(String name) {
        Certificate certificate=certificateRepository.findCertificateByCertificate_name(name);
        if (certificate == null) {
            throw new ApiException("certificate not found");
        }
        return certificate;
    }
}
