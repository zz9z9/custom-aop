package springbasic.customaop.member.serviceimpl.init;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberRepository;
import springbasic.customaop.member.MemberService;
import springbasic.customaop.logger.MyLogger;

@Service("initVer")
public class MemberServiceImpl implements MemberService {

    private MyLogger logger = new MyLogger();
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save() {
        logger.start();

        repository.save(new Member(1L, "초기버전"));

        logger.end();
    }

    @Override
    public void find() {
        logger.start();

        repository.findById(1L);

        logger.end();
    }
}