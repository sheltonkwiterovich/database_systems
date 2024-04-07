package com.database.greatlistens.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.database.greatlistens.model.Member;

@Service
public interface MemberService {
    public void createMember(String name, String phone_num, String email, String password, Date date_of_birth);
    public void updateMember(String mem_id, String name, String phone_num, String email, String password, Date date_of_birth);
    public Member viewMember(String mem_id);
    public void deleteMember(String mem_id);
    public Member login(String email, String password);
    public int getMemberCount();
    public List<Member> getAllMembers();
}
