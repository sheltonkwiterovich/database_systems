package com.database.greatlistens.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.database.greatlistens.exception.EmailAlreadyExistsException;
import com.database.greatlistens.model.Audiobook;
import com.database.greatlistens.model.Buys;
import com.database.greatlistens.model.Member;
import com.database.greatlistens.repository.AudiobookRepository;
import com.database.greatlistens.repository.BuysRepository;
import com.database.greatlistens.repository.MemberRepository;
import com.database.greatlistens.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BuysRepository buysRepository;

    @Autowired
    private AudiobookRepository audiobookRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void createMember(String name, String phone_num, String email, String password, Date date_of_birth) {
        if (memberRepository.emailExists(email) > 0) {
            throw new EmailAlreadyExistsException("An account with this email already exists.");
        }
        int id_num = memberRepository.getMemberCount();
        String mem_id = "M" + Integer.toString(id_num);
        while (memberRepository.memberExists(mem_id) != 0) {
            id_num +=1;
            mem_id = "M" + Integer.toString(id_num);
        }
        String encryptedPassword = passwordEncoder.encode(password);

        memberRepository.insertIntoMember(mem_id, name, phone_num, email, encryptedPassword, date_of_birth);
    }

    @Override
    public void updateMember(String mem_id, String name, String phone_num, String email, String password, Date date_of_birth) {
        String encryptedPassword = null;
        if (password != null) {
            encryptedPassword = passwordEncoder.encode(password);
            memberRepository.updateMember(mem_id, name, phone_num, email, encryptedPassword, date_of_birth);
        }
        else {
            memberRepository.updateMemberNoPassword(mem_id, name, phone_num, email, date_of_birth);
        }
    }

    @Override
    public Member viewMember(String mem_id) {
        return memberRepository.getMemberById(mem_id);
    }

    @Override
    public void deleteMember(String mem_id) {
        memberRepository.deleteMember(mem_id);
    }

    @Override
    public Member login(String email, String password) {
        Member member = memberRepository.getMemberByEmail(email);
        if (member != null && passwordEncoder.matches(password, member.getPassword())) {
            return member;
        }
        return null;
    }

    @Override
    public int getMemberCount() {
        return memberRepository.getMemberCount();
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    @Override
    public List<Audiobook> getBooksBoughtByMember(String mem_id) {
        List<Buys> booksIDsBoughtByMember = buysRepository.getBooksBoughtByMember(mem_id);
        List<Audiobook> booksBoughtByMember = new ArrayList<>();
        for (Buys book : booksIDsBoughtByMember) {
            int book_id = book.getBook_id();
            Audiobook audiobook = audiobookRepository.searchByAudiobookId(book_id);
            booksBoughtByMember.add(audiobook);
        }
        return booksBoughtByMember;
    }
}
