package springbasic.customaop.member.serviceimpl.ver3;

import org.springframework.stereotype.Service;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberRepository;
import springbasic.customaop.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save() {
        repository.save(new Member(1L, "ver3 - 의존성 주입 버전"));
    }

    @Override
    public Member find() {
        Member findMember = repository.findById(1L).orElse(null);
        return findMember;
    }
}


