package pl.uwm.sportclub.manager;

import pl.uwm.sportclub.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository extends BaseRepository<Member>{
    private List<Member> members = new ArrayList<>();

}
