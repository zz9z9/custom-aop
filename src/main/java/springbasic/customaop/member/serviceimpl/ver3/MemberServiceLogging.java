package springbasic.customaop.member.serviceimpl.ver3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberService;

@Service("dependencyInjectionVer")
public class MemberServiceLogging implements MemberService {

    private MyLogger logger = new MyLogger();
    private final MemberService service;

    public MemberServiceLogging(@Qualifier("memberServiceImpl") MemberService service) {
        this.service = service;
    }

    @Override
    public void save() {
        logger.start();

        service.save();

        logger.end();
    }

    @Override
    public Member find() {
        logger.start();

        Member findMember = service.find();

        logger.end();

        return findMember;
    }
}
