package pl.uwm.sportclub.service;

import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.model.Member;
import utils.ConsoleColors;

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
            System.out.println(ConsoleColors.RED + ConsoleColors.BOLD + "The pass has expired for "+ ConsoleColors.RESET  + member.getFirstName() + " " + member.getLastName());
            return false;
        }
        System.out.println(ConsoleColors.GREEN + ConsoleColors.BOLD + "Access verified positively. Have a nice trainig "+ ConsoleColors.RESET + member.getFirstName() + "!");
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
