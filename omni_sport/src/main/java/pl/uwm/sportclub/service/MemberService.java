package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.model.Member;

import java.time.LocalDate;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    public boolean verifyAccess(int memberId)
    {
        Member member = memberRepository.findById(memberId);
        if(member == null)
        {
            System.out.println("There is no member with that ID");
            return false;
        }
        if(member.getMembershipExpiryDate().isBefore(LocalDate.now()))
        {
            System.out.println("The pass has expired for " + member.getFirstName() + " " + member.getLastName());
            return false;
        }
        System.out.println("Access verified positively. Have a nice trainig " + member.getFirstName() + "!");
        return true;
    }

    public void registerNewMember(Member newMember)
    {
        if(newMember.getFirstName() == null || newMember.getLastName() == null)
        {
            System.out.println("There is no data");
            return;
        }
        memberRepository.add(newMember);
        System.out.println("Registered successfully " + newMember.getFirstName() + " " + newMember.getLastName());
    }
}
