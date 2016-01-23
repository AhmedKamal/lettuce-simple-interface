# Simple-Redis - A simple interface for caching in redis
===============================
[![Build Status](https://travis-ci.org/AhmedKamal/simple-redis.svg?branch=master)](https://travis-ci.org/AhmedKamal/simple-redis) [![Coverage Status](https://coveralls.io/repos/github/AhmedKamal/simple-redis/badge.svg?branch=master)](https://coveralls.io/github/AhmedKamal/simple-redis?branch=master)



A simple interface for caching objects in redis via lettuce in seconds !

- Simple-Redis is based on [lettuce](https://github.com/mp911de/lettuce) 3.3.2 Final.

About Lettuce
-------
[Lettuce](https://github.com/mp911de/lettuce) is a scalable thread-safe Redis client providing both synchronous and
asynchronous connections. Multiple threads may share one connection provided
they avoid blocking and transactional operations such as BLPOP, and MULTI/EXEC.
Multiple connections are efficiently managed by the excellent netty NIO
framework. Support for advanced Redis features such as Sentinel, Cluster and Redis data models
is included.

Lettuce has been tested against Redis 3.0.

Usage
-------
```java
    SimpleRedisConnection redisConnection = new SimpleRedisConnection(new RedisClient(new RedisURI(host, port, 2, TimeUnit.SECONDS)));
    Person person = Person.createPersonAdam();
    redisConnection.cache("People", "Adam", person);
    
    Person retrievedPerson = redisConnection.get("People", "Adam");
    redisConnection.clear("People", "Adam");
```
Bugs and Feedback
-----------

For bugs, questions and discussions please use the [Github Issues](https://github.com/AhmedKamal/simple-redis/issues).

License
-------

* [Apache License 2.0] (http://www.apache.org/licenses/LICENSE-2.0)
