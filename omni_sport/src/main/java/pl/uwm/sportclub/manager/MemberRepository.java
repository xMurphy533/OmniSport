package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository extends BaseRepository<Member>{
    private List<Member> members = new ArrayList<>();



    public List<Member> findByLastName(String lastName)
    {
        List<Member> foundItems = new ArrayList<>();
        for(Member m : members)
        {
            if(m.getLastName().equalsIgnoreCase(lastName))
            {
                foundItems.add(m);
            }
        }
        return foundItems;
    }
}
