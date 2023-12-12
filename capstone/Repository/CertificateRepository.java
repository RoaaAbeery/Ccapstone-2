package com.example.capstone.Repository;

import com.example.capstone.Model.Certificate;
import com.example.capstone.Model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Integer> {
    Certificate findCertificateById(Integer id);

    @Query("SELECT c FROM Certificate c WHERE c.certificate_date BETWEEN :startDate AND :endDate")
    List<Certificate> findCertificatesInDateRange(LocalDate startDate, LocalDate endDate);
    @Query("select c from Certificate c where c.certificate_name=?1 ")
    Certificate findCertificateByCertificate_name(String title );
}
