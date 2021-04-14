package springbasic.customaop.member.serviceimpl.ver3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberService;

@Service("proxyVer")
public class MemberServiceProxy implements MemberService {

    private MyLogger logger = new MyLogger();
    private final MemberService service;

    public MemberServiceProxy(@Qualifier("memberServiceImpl") MemberService service) {
        this.service = service;
    }

    @Override
    public void save() {
        logger.start();
        service.save();
        logger.end();
    }

    @Override
    public Member find(long id) {
        logger.start();
        Member findMember = service.find(id);
        logger.end();

        return findMember;
    }
}

