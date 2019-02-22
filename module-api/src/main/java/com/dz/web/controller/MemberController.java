package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import com.dz.domain.entity.Member;
import com.dz.domain.entity.Memmber;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/memmbers")
public class MemberController {

    @GetMapping("/members")
    public List<Member> getListMember(){
        return null;
    }

    @GetMapping("/member/{id}")
    public Member getMember(){
        return null;
    }

    @PostMapping("/member")
    public Member createMember(){
        return null;
    }

    @PutMapping("/member/{no}")
    public Member updateMember(@RequestBody Memmber member, @PathVariable int no){
        return null;
    }

    @DeleteMapping("/member/{no}")
    public ResponseEntity deleteMember(@PathVariable int no){

        //1.삭제 로직

        if(true){
            //정상
        }else{
            //실패
        }

        ResponseEntity responseEntity = ResponseSuccess.success();
        return null;
    }

}
