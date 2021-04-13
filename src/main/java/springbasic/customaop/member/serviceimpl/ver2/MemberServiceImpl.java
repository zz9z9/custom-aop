package springbasic.customaop.member.serviceimpl.ver2;

import org.springframework.stereotype.Service;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberRepository;

@Service("templateMethodVer")
public class MemberServiceImpl extends SuperServiceImpl {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void doSave() {
        repository.save(new Member(1L, "ver2 - 템플릿 메소드 버전"));
    }

    @Override
    public Member doFind() {
        Member findMember = repository.findById(1L).orElse(null);
        return findMember;
    }
}


