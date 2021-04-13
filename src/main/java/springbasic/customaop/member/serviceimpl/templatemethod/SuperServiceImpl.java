package springbasic.customaop.member.serviceimpl.templatemethod;

import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.MemberService;

public abstract class SuperServiceImpl implements MemberService {

    private MyLogger logger = new MyLogger();

    public abstract void doSave();
    public abstract void doFind();

    public void save() {
        logger.start();
        doSave();
        logger.end();
    }

    public void find() {
        logger.start();
        doFind();
        logger.end();
    }
}





