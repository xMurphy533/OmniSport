package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> members = new ArrayList<>();
    public void addMember(Member member)
    {
        if(member != null)
        {
            members.add(member);
            System.out.println("New member added successfully");
        }
        else
            throw new IllegalArgumentException("Member can't be 'null'");
    }
    public List<Member> getMembers()
    {
        return members;
    }
}
