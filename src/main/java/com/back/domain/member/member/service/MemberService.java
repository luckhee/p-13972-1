package com.back.domain.member.member.service;


import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.repository.MemberRepository;
import com.back.global.exception.ServiceException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(String name, String password, String nickname) {
        memberRepository
                .findByuserName(name)
                .ifPresent(_member -> {
                    throw new ServiceException("409-1", "이미 존재하는 아이디입니다.");
                });

        Member member = new Member(name, password, nickname);
        member.setUserName(name);
        member.setPassword(password);
        member.setNickname(nickname);
        return memberRepository.save(member);
    }

    public long count() {
        return memberRepository.count();
    }

    public Member findById(int i) {
        return memberRepository.findById(i).get();


    }

    public Optional<Member> findByUserName(@NotBlank @Size(min = 2, max = 100) String name) {

        return memberRepository.findByuserName(name);

    }

    public Optional<Member> findByApiKey(@NotBlank @Size(min = 30, max = 50) String apiKey) {
        return memberRepository.findByapiKey(apiKey);
    }
}
