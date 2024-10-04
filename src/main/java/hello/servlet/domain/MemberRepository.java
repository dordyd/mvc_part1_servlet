package hello.servlet.domain;

import java.util.List;

public interface MemberRepository {

    public Member save();

    public Member findById();

    public List<Member> findAll();

    public void clearStore(); // 데이터 테스트시 정리용도
}
