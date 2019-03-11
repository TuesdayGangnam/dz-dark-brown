package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import com.dz.domain.dto.MemberDto;
import com.dz.domain.entity.Member;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dz.constant.ResponseCode.ILLEGAL_ARGS_FAIL;
import static com.dz.exceptions.LogicExcepion.internalException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {


    private MemberService memberService;

    @GetMapping("")
    public ResponseEntity getMemberList(@ModelAttribute @Valid MemberDto memberDto, Errors errors) {

        if(errors.hasErrors()){
            throw internalException(ILLEGAL_ARGS_FAIL);
        }

        Member memberList = memberDto.toEntity();

        List<Member> members = new ArrayList<>();
        members.add(memberList);
        // 회원 조회
        return ResponseSuccess.success(members);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity getMember(@PathVariable long id) {
        Member member = memberService.findByUserId(id);
        MemberDto memberDto = member.toEntity();

        Map<String, Object> responseResult = new HashMap<>();
        responseResult.put("member", memberDto);

        return ResponseSuccess.success(responseResult);
    }

    @PostMapping("/member")
    public ResponseEntity saveMember(@RequestBody MemberDto memberDto) {
        memberService.create(memberDto.toEntity());

        return ResponseSuccess.success();
    }

    @PutMapping("/member")
    public ResponseEntity updateMember(@RequestBody MemberDto memberDto) {
        memberService.update(memberDto.toEntity());

        return ResponseSuccess.success();
    }

    @DeleteMapping("/member")
    public ResponseEntity deleteMember(@RequestBody MemberDto memberDto) {
        memberService.delete(memberDto.toEntity());

        return ResponseSuccess.success();
    }

}
