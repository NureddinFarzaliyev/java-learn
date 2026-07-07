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
