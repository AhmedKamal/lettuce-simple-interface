package redis;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import org.junit.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:a.abdelfatah@live.com">Ahmed Kamal</a>
 * @since 23.01.16 09:17
 */
public class AbstractTest {

    protected static RedisClient client;
    private static String host = "127.0.0.1";
    private static int port = 6379;

    @BeforeClass
    public static void setupClient() {
        client = getRedisClient();
    }

    protected static RedisClient getRedisClient() {
        return new RedisClient(new RedisURI(host, port, 10, TimeUnit.SECONDS));
    }

}
