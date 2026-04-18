package pl.uwm.sportclub.app;

import pl.uwm.sportclub.manager.AdminRepository;
import pl.uwm.sportclub.manager.CoachRepository;
import pl.uwm.sportclub.manager.MemberRepository;
import pl.uwm.sportclub.manager.UserRepository;
import pl.uwm.sportclub.model.Admin;
import pl.uwm.sportclub.model.Coach;
import pl.uwm.sportclub.model.Member;
import pl.uwm.sportclub.model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        UserRepository userRepository = new UserRepository();
        AdminRepository adminRepository = new AdminRepository();
        CoachRepository coachRepository = new CoachRepository();
        User u1 = new User(1,
                "Nikodem",
                "Kaczmarczyk",
                "nikodemkaczmarczyk48@gmail.com",
                LocalDate.of(2005, 3, 19));
        userRepository.addUser(u1);
        //System.out.println(u1.toString());
        Member m1 = new Member(2,
                "Karol", "Nowak",
                "karol.nowak@gmail.com",
                LocalDate.of(2000, 7, 12),
                "Football",
                true);
        //System.out.println(m1.toString());
        memberRepository.addMember(m1);
        Coach c1 = new Coach(3,
                "Przemysław",
                "Kowalski",
                "przemek.k70@gmail.com",
                LocalDate.of(1970, 12, 2),
                "Skiing");
        coachRepository.addCoach(c1);
        //System.out.println(c1.toString());
        Admin a1 = new Admin(1,
                "Jan",
                "Łada",
                "jlada@gmail.com",
                LocalDate.of(1990, 4, 6),
                "MODERATOR",
                LocalDate.now());
        adminRepository.addAdmin(a1);
        //System.out.println(a1.toString());
        Member m2 = new Member(3,
                "Łukasz", "Ocimek",
                "lukoci12@gmail.com",
                LocalDate.of(1998, 5, 4),
                "Kickboxing",
                true);
        memberRepository.addMember(m2);
        Member m3 = new Member(4,
                "Łukasz", "Kaczyński",
                "lukikaczka@gmail.com",
                LocalDate.of(2005, 8, 10),
                "Volleyball",
                false);
        memberRepository.addMember(m3);
        //System.out.println(memberRepository.findById(3));
        memberRepository.removeById(3);
        for(Member m : memberRepository.getMembers())
        {
            System.out.println(m.toString());
            System.out.println("===========");
        }
    }
}
