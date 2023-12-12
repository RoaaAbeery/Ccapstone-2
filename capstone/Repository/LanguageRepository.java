package com.example.capstone.Repository;

import com.example.capstone.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Language findLanguageById(Integer id);
    @Query("select l from Language l where l.language_name=?1 ")
    Language findLanguageByLanguage_name(String Language_name );
}
