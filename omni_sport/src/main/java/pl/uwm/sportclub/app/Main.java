package pl.uwm.sportclub.app;


import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.model.Member;
import pl.uwm.sportclub.service.MemberService;
import pl.uwm.sportclub.ui.ReceptionMenu;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        ReceptionMenu receptionMenu = new ReceptionMenu(memberService);
        receptionMenu.start();
    }
}
