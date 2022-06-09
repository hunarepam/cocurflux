package by.hunar.cocurflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SchedulerTest {

    @Test
    void testThreads() throws InterruptedException {
        Flux.range(1, 8)

            .map(element -> {
                log(element.toString());
                return element.toString();
            })
            .subscribeOn(Schedulers.boundedElastic())
            .subscribeOn(Schedulers.single())
            .subscribe();

        Thread.sleep(5000);
    }

    private void log(String value) {
        System.out.println("Value " + value + " from " + Thread.currentThread().getName());
    }
}
