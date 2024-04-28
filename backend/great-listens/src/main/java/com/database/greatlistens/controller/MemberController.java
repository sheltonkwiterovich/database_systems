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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.greatlistens.Token.TokenManager;
import com.database.greatlistens.model.Member;
import com.database.greatlistens.service.MemberService;

@Controller
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<String> createMember(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        String phone_num = (String) requestBody.get("phone_num");
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        Date date_of_birth = Date.valueOf((String) requestBody.get("date_of_birth"));

        try {
            memberService.createMember(name, phone_num, email, password, date_of_birth);
            return ResponseEntity.ok("Member created successfully.");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create member: " + e.getMessage());
        }

    }


    @PutMapping("/update")
    public ResponseEntity updateMember(@RequestHeader("Authorization")String token, @RequestBody Map<String, Object> requestBody) {
        String mem_id = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, mem_id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        String name = (String) requestBody.get("name");
        String phone_num = (String) requestBody.get("phone_num");
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        Date date_of_birth = Date.valueOf((String) requestBody.get("date_of_birth"));

        memberService.updateMember(mem_id, name, phone_num, email, password, date_of_birth);

        return ResponseEntity.ok("Member updated successfully");
    }

    @GetMapping("/view")
    public ResponseEntity viewMember(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
    
    
        String mem_id = TokenManager.getTokenMemId(token);
    
        if (mem_id == null || !TokenManager.validateToken(token, mem_id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    
        Member member = memberService.viewMember(mem_id);
    
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        String mem_id = (String) requestBody.get("mem_id");
        if (!TokenManager.validateToken(token, mem_id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        memberService.deleteMember(mem_id);

        return ResponseEntity.ok("Member deleted successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");

        Member member = memberService.login(email, password);
        if (member != null) {
            String token = TokenManager.generateToken(member.getMem_id());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {

        String mem_id = TokenManager.getTokenMemId(token);
    
        if (mem_id == null || !TokenManager.validateToken(token, mem_id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    
        // Invalidate the token
        TokenManager.invalidateToken(token);
    
        return ResponseEntity.ok("Logged out successfully");
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
    