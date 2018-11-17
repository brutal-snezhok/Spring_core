package aspects;

import com.tsyrulik.core.aspects.StatisticsAspect;
import com.tsyrulik.core.logger.impl.CombinedEventLogger;
import com.tsyrulik.core.logger.impl.ConsoleEventLogger;
import org.aspectj.lang.JoinPoint;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestStatisticsAspect {

    @Test
    public void testStatisticCounter() {
        JoinPoint jp = mock(JoinPoint.class);
        when(jp.getTarget())
                .thenReturn(new ConsoleEventLogger())
                .thenReturn(new CombinedEventLogger())
                .thenReturn(new ConsoleEventLogger());
        StatisticsAspect aspect = new StatisticsAspect();
        aspect.count(jp);
        aspect.count(jp);
        aspect.count(jp);
        verify(jp, atMost(3)).getTarget();
        Map<Class<?>, Integer> counters = aspect.getCounter();
        assertEquals(2, counters.size());
        assertEquals(2, counters.get(ConsoleEventLogger.class).intValue());
        assertEquals(1, counters.get(CombinedEventLogger.class).intValue());
    }
}