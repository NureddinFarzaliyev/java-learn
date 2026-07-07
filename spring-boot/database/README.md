## Connecting to PostgreSQL DB

```java
package com.frzlyv.database;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

  private final DataSource dataSource;

  public DatabaseApplication(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public static void main(String[] args) {
    SpringApplication.run(DatabaseApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("DATASOURCE: " + dataSource.toString());

    final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
    restTemplate.execute("select 1");
  }

}
```

```application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=temppassword
spring.datasource.driver-class-name=org.postgresql.Driver
```

```yaml docker-compose.yml
version: "3.1"
services:
  db:
    image: postgres
    ports:
      - "5432:5432"
    restart: always
    environment:
      POSTGRES_PASSWORD: temppassword
```

## Creating Schema in PostgreSQL

In `main/resources`, `schema.sql` and `data.sql` files are used to initialize schema and insert data.

Example:

```sql schema.sql
DROP TABLE IF EXISTS widgets;

DROP SEQUENCE IF EXISTS widgets_id_seq;
CREATE SEQUENCE widgets_id_seq INCREMENT 1 MINVALUE 1 CACHE 1;

CREATE TABLE widgets (
  id bigint DEFAULT nextval('widgets_id_seq') NOT NULL,
  name text,
  purpose text,
  CONSTRAINT widgets_pkey PRIMARY KEY (id)
);
```

```sql data.sql
INSERT INTO widgets (id, name, purpose) VALUES
(1, 'Widget 1', 'First Widget'),
(2, 'Widget 2', 'Second Widget'),
(3, 'Widget 3', 'Third Widget');
```

Then, following property is used in `application.properties`

```application.properties
spring.sql.init.mode=always
```
