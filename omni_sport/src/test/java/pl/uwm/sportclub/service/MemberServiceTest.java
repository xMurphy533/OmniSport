package pl.uwm.sportclub.service;

import org.junit.jupiter.api.Test;
import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.model.Member;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    @Test
    void verifyAccess_shouldDenyWhenExpired() {
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        Member expiredMember = new Member(1,
                "Jan",
                "Kowalski",
                "janekkowal@gmail.com",
                LocalDate.of(2005, 3, 19),
                "Ping Pong",
                true,
                LocalDate.now().minusDays(1)
                );
        memberRepository.add(expiredMember);
        boolean canEnter = memberService.verifyAccess(1);
        assertFalse(canEnter, "System should deny member with expired pass!");
    }

    @Test
    void registerNewMember_shouldAddMemberWhenDataIsValid() {
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        Member validMember = new Member(2,
                "Karol", "Nowak",
                "karol.nowak@gmail.com",
                LocalDate.of(2000, 7, 12),
                "Football",
                true,
                LocalDate.now().plusMonths(1));

        memberService.registerNewMember(validMember);

        int repoSize = memberRepository.getAllItems().size();

        assertEquals(1, repoSize, "Repo should have one member after register");
        String savedName = memberRepository.getAllItems().get(0).getFirstName();
        assertEquals("Karol", savedName, "Name in repo should be considered with that at registration");
    }

    @Test
    void registerNewMember_shouldNotAddMemberWhenFirstNameIsNull()
    {
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        Member invalidMember = new Member(2,
                null, "Nowak",
                "karol.nowak@gmail.com",
                LocalDate.of(2000, 7, 12),
                "Football",
                true,
                LocalDate.now().plusMonths(1));

        memberService.registerNewMember(invalidMember);

        int repositorySize = memberRepository.getAllItems().size();
        assertEquals(0, repositorySize, "System should not save user without first name");
    }
}