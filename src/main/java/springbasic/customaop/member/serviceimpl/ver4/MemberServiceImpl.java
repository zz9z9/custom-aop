package springbasic.customaop.member.serviceimpl.ver4;

import org.springframework.stereotype.Service;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberRepository;
import springbasic.customaop.member.MemberService;

@Service("dynamicProxyVer")
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save() {
        repository.save(new Member(1L, "ver4 - 다아나믹 프록시 버전"));
    }

    @Override
    public Member find() {
        Member findMember = repository.findById(1L).orElse(null);
        return findMember;
    }
}






