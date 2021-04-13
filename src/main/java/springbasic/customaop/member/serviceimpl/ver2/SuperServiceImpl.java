package springbasic.customaop.member.serviceimpl.ver2;

import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.Member;
import springbasic.customaop.member.MemberService;

public abstract class SuperServiceImpl implements MemberService {

    private MyLogger logger = new MyLogger();

    public abstract void doSave();
    public abstract Member doFind();

    public void save() {
        logger.start();
        doSave();
        logger.end();
    }

    public Member find() {
        logger.start();
        Member findMember = doFind();
        logger.end();

        return findMember;
    }
}





