package com.database.greatlistens.repository;

import com.database.greatlistens.model.Member;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    // get count of members
    @Query(value = "SELECT COUNT(*) FROM member", nativeQuery = true)
    int getMemberCount();

    // get all members
    @Query(value = "SELECT * FROM member", nativeQuery = true)
    List<Member> getAllMembers();
    
    // get member by id
    @Query(value = "SELECT * FROM member WHERE mem_id = :mem_id", nativeQuery = true)
    Member getMemberById(@Param("mem_id") String mem_id);

    // get member by email and password
    @Query(value = "SELECT * FROM member WHERE email = :email", nativeQuery = true)
    Member getMemberByEmail(@Param("email") String email);

    // insert into member
    @Transactional
    @Query(value = "INSERT INTO member (mem_id, name, phone_num, email, password, date_of_birth) VALUES (:mem_id, :name,:phone_num,:email,:password, :date_of_birth)", nativeQuery = true)
    @Modifying
    void insertIntoMember(@Param("mem_id") String mem_id, @Param("name") String name, @Param("phone_num") String phone_num, @Param("email") String email, @Param("password") String password, @Param("date_of_birth") Date date_of_birth);

    // update member
    @Transactional
    @Query(value = "UPDATE member SET name = :name, phone_num = :phone_num, email = :email, password = :password, date_of_birth = :date_of_birth WHERE mem_id = :mem_id", nativeQuery = true)
    @Modifying
    void updateMember(@Param("mem_id") String mem_id, @Param("name") String name, @Param("phone_num") String phone_num, @Param("email") String email, @Param("password") String password, @Param("date_of_birth") Date date_of_birth);

    // delete member
    @Transactional
    @Query(value = "DELETE FROM member WHERE mem_id = :mem_id", nativeQuery = true)
    @Modifying
    void deleteMember(@Param("mem_id") String mem_id);

    @Query(value = "SELECT COUNT(*) AS member_count FROM member WHERE mem_id = :mem_id", nativeQuery = true)
    int memberExists(@Param("mem_id") String mem_id); 
}

