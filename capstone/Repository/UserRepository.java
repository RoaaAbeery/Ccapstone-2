package com.example.capstone.Repository;

import com.example.capstone.Model.Certificate;
import com.example.capstone.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUsersById(Integer id);
    @Query("select u from User u where u.email=?1 and u.password=?2")
     User findUsersByEmailAndPassword(String email, String password);

    @Query("select u from User u where u.firstName=?1 and u.lastName=?2")

    User findUsersByFirstNameAndLastName(String firstName,String lastName);
    @Query("select u from User u where u.id=?1 and u.password=?2")

    User findUsersByIdAndPassword(Integer id ,String password);
    @Query("select u from User u where u.age>=?1")
    List<User> findUserByAge(Integer age);


}
