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
        repository.save(new Member(1L, "ver3 - 프록시 버전"));
    }

    @Override
    public Member find(long id) {
        Member findMember = repository.findById(id).orElse(null);
        return findMember;
    }
}




