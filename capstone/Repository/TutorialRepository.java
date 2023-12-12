package com.example.capstone.Repository;

import com.example.capstone.Model.Language;
import com.example.capstone.Model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial,Integer> {
    Tutorial findTutorialById(Integer id);
    @Query("select t from Tutorial t where t.user_id=?1")
    List  <Tutorial> findTutorialByUser_id(Integer user_Id);
    @Query("select t from Tutorial t where t.title=?1 ")
     Tutorial findTutorialByTitle(String title );

@Query("select t from Tutorial t where t.difficulty_level=?1")
    List<Tutorial> findTutorialByDifficulty_level(String Difficulty_level);

    @Query("select t from Tutorial t where t.favorites=true and t.user_id=?1")
List<Tutorial> findByUser_idAndFavoritesIsTrue(Integer user_id);
    @Query("select t from Tutorial t where t.user_id=?1 and t.id=?2")
    Tutorial findTutorialByUser_idAndId(Integer user_id,Integer id);

    @Query("select count (*) from Tutorial t where t.user_id=?1 and t.favorites=false ")
    Integer countByFavoritesIsFalse(Integer user_id);
    @Query("select count (*) from Tutorial t where t.user_id=?1 and t.favorites=true ")
    Integer countByFavoritesIsTrue(Integer user_id);

    @Query("select t from Tutorial t where t.author=?1")
    List<Tutorial> findTutorialByAuthor(String author);
}
