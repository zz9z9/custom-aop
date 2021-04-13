package springbasic.customaop.member.serviceimpl.templatemethod;

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
        repository.save(new Member(1L, "템플릿메소드버전"));
    }

    @Override
    public void doFind() {
        repository.findById(1L);
    }
}


