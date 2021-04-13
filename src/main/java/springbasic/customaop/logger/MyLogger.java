package springbasic.customaop.logger;

import java.util.logging.Logger;

public class MyLogger {
    private Logger logger = Logger.getGlobal();
    long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
        logger.info("===== 메서드 시작 =====");
    }

    public void end() {
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime-startTime)/1000.0;
        logger.info("경과시간 : "+elapsedTime+"\n");
    }
}
