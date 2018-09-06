# Simple search system sample
Based on spring boot, spring data jpa, hibernate search.

## Required actions
Prepared postgreSQL database.
```
spring.datasource.url=jdbc:postgresql:users
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
```

```sql
CREATE TABLE public.users
(
    id bigint,
    name character varying(255),
    role character varying(255)
);
```

## Customizing
Index properties:
Index type: `spring.jpa.properties.hibernate.search.default.directory_provider = filesystem`
Default index directory: `spring.jpa.properties.hibernate.search.default.indexBase = /var/netgloo_blog/lucene/indexes/`

## Execution
To run:
```bash
./gradlew bootRun
```

## Testing
```bash
 curl localhost:8080/users/search?text=test -v
```

```bash
curl localhost:8080/users/search -v
```

## Thanks to
https://blog.codecentric.de/en/2017/06/kotlin-spring-working-jpa-data-classes/
https://kotlinlang.org/docs/tutorials/spring-boot-restful.html
https://github.com/JetBrains/kotlin-examples/tree/master/tutorials/spring-boot-restful
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html
https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/
https://blog.jetbrains.com/kotlin/2016/12/kotlin-1-0-6-is-here/
https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#_configuration
https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-hibernate-search
https://github.com/dnno/spring-kotlin-jpa/blob/master/pom.xml#L110
https://kotlinlang.org/docs/reference/compiler-plugins.html
http://blog.netgloo.com/2014/11/23/spring-boot-and-hibernate-search-integration/
https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-hibernate-search