package com.example.demo.dog.controller;


import com.example.demo.dog.dto.DogResponseDto;
import com.example.demo.dog.dto.DogSaveRequestDto;
import com.example.demo.dog.dto.DogUpdateRequestDto;
import com.example.demo.dog.service.DogService;
import com.example.demo.member.dao.MemberRepository;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.Member;
import com.example.demo.member.vo.MemberResponseDto;
import com.example.demo.member.vo.MemberSaveRequestDto;
import com.example.demo.member.vo.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class DogApiController {

    private final DogService dogService;
    private final MemberRepository memberRepository;
    private final FindByIndexNameSessionRepository sessionRepository;


    // 강아지 정보 수정 API
    @PutMapping("/api/member/dogs/settings/{id}")
    public Long DogupdateForm(@PathVariable Long id, @RequestBody DogUpdateRequestDto requestDto) {

        return dogService.update(id, requestDto);
    }


    //강아지 정보 삭제 API
    @DeleteMapping("/api/member/dogs/delete/{id}")
    public Long delete(@PathVariable Long id) {
        dogService.delete(id);
        return id;
    }


    // 관리자, 회원 반려견 정보수정 API
    @PutMapping("/api/admin/dogs/settings/{id}")
    public Long adminDogSettingsForm(@PathVariable Long id, @RequestBody DogUpdateRequestDto requestDto) {

        return dogService.update_admin_dog(id, requestDto);
    }

    // 관리자, 회원 반려견 정보삭제 API
    @DeleteMapping("/api/admin/dogs/delete/{id}")
    public Long adminDogDelete(@PathVariable Long id) {
        dogService.delete(id);

        return id;
    }
}