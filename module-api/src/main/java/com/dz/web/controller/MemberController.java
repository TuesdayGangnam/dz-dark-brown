package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import com.dz.domain.dto.MemberDto;
import com.dz.domain.entity.Member;
import com.dz.domain.entity.MemberEntity;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static com.dz.constant.ResponseCode.ILLEGAL_ARGS_FAIL;
import static com.dz.exceptions.LogicExcepion.internalException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public ResponseEntity getListMember(@ModelAttribute @Valid MemberDto memberDto, Errors errors) {

        if(errors.hasErrors()){
            throw internalException(ILLEGAL_ARGS_FAIL);
        }

        MemberEntity memberEntity = memberDto.toEntity(1234);

        List<MemberEntity> members = new ArrayList<>();
        members.add(memberEntity);
        // 회원 조회
        return ResponseSuccess.success(members);
    }

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable int id) {
        return null;
    }

    @PostMapping("/member")
    public Member createMember() {
        return null;
    }

    @PutMapping("/member/{no}")
    public Member updateMember(@RequestBody Member member, @PathVariable int no) {
        return null;
    }

    @DeleteMapping("/member/{no}")
    public ResponseEntity deleteMember(@PathVariable int no) {

        //1.삭제 로직

        if (true) {
            //정상
        } else {
            //실패
        }

        ResponseEntity responseEntity = ResponseSuccess.success();
        return null;
    }

}
