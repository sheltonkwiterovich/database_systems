package com.database.greatlistens.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.model.Member;
import com.database.greatlistens.service.MemberService;

@Controller
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity createMember(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        String phone_num = (String) requestBody.get("phone_num");
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        Date date_of_birth = Date.valueOf((String) requestBody.get("date_of_birth"));
        System.out.println("HELLO");
        memberService.createMember(name, phone_num, email, password, date_of_birth);

        return ResponseEntity.ok("Member created successfully");
    }


    @PutMapping("/update")
    public ResponseEntity updateMember(@RequestBody Map<String, Object> requestBody) {
        String mem_id = (String) requestBody.get("mem_id");
        String name = (String) requestBody.get("name");
        String phone_num = (String) requestBody.get("phone_num");
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        Date date_of_birth = Date.valueOf((String) requestBody.get("date_of_birth"));

        memberService.updateMember(mem_id, name, phone_num, email, password, date_of_birth);

        return ResponseEntity.ok("Member updated successfully");
    }

    @GetMapping("/view")
    public ResponseEntity<Member> viewMember(@RequestBody Map<String, Object> requestBody) {
        String mem_id = (String) requestBody.get("mem_id");

        Member member = memberService.viewMember(mem_id);

        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestBody Map<String, Object> requestBody) {
        String mem_id = (String) requestBody.get("mem_id");

        memberService.deleteMember(mem_id);

        return ResponseEntity.ok("Member deleted successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");

        Member member = memberService.login(email, password);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/count")
    public int getMemberCount() {
        return memberService.getMemberCount();
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
    
