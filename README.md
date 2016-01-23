# Simple-Redis - A simple interface for objects caching in redis
===============================

![Build Status](https://travis-ci.org/AhmedKamal/simple-redis.svg?branch=master) [![CoverageStatus](https://coveralls.io/repos/github/AhmedKamal/simple-redis/badge.svg?branch=master)](https://coveralls.io/github/AhmedKamal/simple-redis?branch=master)

A simple interface for caching objects in redis via lettuce in seconds !

-Simple-Redis is based on [lettuce](https://github.com/mp911de/lettuce) 3.3.2 Final.

Usage
-------
```java
    SimpleRedisConnection redisConnection = new SimpleRedisConnection(new RedisClient(new RedisURI(host, port, 2, TimeUnit.SECONDS)));
    Person person = Person.createPersonAdam();
    redisConnection.cache("People", "Adam", person);
    
    Person retrievedPerson = redisConnection.get("People", "Adam");
    redisConnection.clear("People", "Adam");
```

License
-------

* [Apache License 2.0] (http://www.apache.org/licenses/LICENSE-2.0)
