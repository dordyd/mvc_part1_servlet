package hello.servlet.domain.member;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
//@Component
//@Qualifier("memoryMemberRepository")
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 0L;

    public static MemoryMemberRepository getInstance(){
        return new MemoryMemberRepository();
    }

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList(store.values());

    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
