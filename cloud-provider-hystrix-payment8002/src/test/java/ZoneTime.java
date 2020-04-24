import org.junit.Test;

import java.time.ZonedDateTime;

public class ZoneTime {

    @Test
    public void ZoneTime(){
        ZonedDateTime now = ZonedDateTime.now();     //java8提供的类，获取所在时区的现在的时间
        System.out.println(now);
    }

}
