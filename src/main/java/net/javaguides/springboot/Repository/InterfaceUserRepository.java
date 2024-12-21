package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.User;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByRolId(Long roleId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.email = :email")
    void updatePasswordByEmail(String email, String password);

    @Query(value = "SELECT COUNT(*) FROM applicant_course", nativeQuery = true)
    Long countTotalApplicantCourseRelations();

    @Query(value = "SELECT * FROM user WHERE role_id = 1", nativeQuery = true)
    List<Applicant> findAllApplicants();

    // SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM your_table WHERE
    // id = :id
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM applicant_course WHERE applicant_id = :id", nativeQuery = true)
    long existsByIdNative(@Param("id") long id);
}
