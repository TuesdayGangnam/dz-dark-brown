package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import com.dz.domain.dto.request.MemberResponseDto;
import com.dz.domain.dto.response.MemberRequestDto;
import com.dz.domain.entity.Member;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dz.constant.ResponseCode.NOT_FOUND_DATA;
import static com.dz.exceptions.LogicExcepion.internalException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findAll();
        List<MemberResponseDto> memberDtoList = members.stream().map(Member::toResponseDto).collect(Collectors.toList());
        return ResponseSuccess.success(memberDtoList);
    }

    @GetMapping("/members/{member_id}")
    public ResponseEntity getMember(@PathVariable long member_id) {

        Optional<Member> memberOptional = memberService.findByUserId(member_id);
        
        if (!memberOptional.isPresent()){
            throw internalException(NOT_FOUND_DATA);
        }

        MemberResponseDto memberresponseDto = memberOptional.get().toResponseDto();

        Map<String, Object> responseResult = new HashMap<>();
        responseResult.put("member", memberresponseDto);

        return ResponseSuccess.success(responseResult);
    }

    @PostMapping("/members")
    public ResponseEntity saveMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        memberService.create(memberRequestDto.toEntity());

        return ResponseSuccess.success();
    }

    @PutMapping("/members/{member_id}")
    public ResponseEntity updateMember(@RequestBody @Valid MemberRequestDto memberRequestDto, @PathVariable long member_id) {
        Optional<Member> memberOptional = memberService.findByUserId(member_id);

        if (!memberOptional.isPresent()) {
            throw internalException(NOT_FOUND_DATA);
        }

        memberRequestDto.setMemberId(member_id);
        memberService.update(memberRequestDto.toEntity());

        return ResponseSuccess.success();
    }

    @DeleteMapping("/members/{member_id}")
    public ResponseEntity deleteMember(@RequestBody @Valid MemberRequestDto memberRequestDto, @PathVariable long member_id) {
        Optional<Member> memberOptional = memberService.findByUserId(member_id);

        if (!memberOptional.isPresent()) {
            throw internalException(NOT_FOUND_DATA);
        }

        memberRequestDto.setMemberId(member_id);
        memberService.delete(memberRequestDto.toEntity());

        return ResponseSuccess.success();
    }
}
