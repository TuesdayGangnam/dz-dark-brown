package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import com.dz.domain.entity.Member;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public ResponseEntity getListMember(){

        return ResponseSuccess.success(memberService.getMemberList());
    }

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable int id){
        return null;
    }

    @PostMapping("/member")
    public Member createMember(){
        return null;
    }

    @PutMapping("/member/{no}")
    public Member updateMember(@RequestBody Member member, @PathVariable int no){
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
