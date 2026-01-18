package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

@Testcontainers
@SpringBootTest
class MySQLIT {

    @Container
    static MySQLContainer mysql = new MySQLContainer("mysql:8.0.44");

    @Test
    void contextLoad() {}
}
