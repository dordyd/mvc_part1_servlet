package hello.servlet.domain.member;

import java.util.List;

public class DBMemberRepository implements MemberRepository {
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public void clearStore() {

    }
}
