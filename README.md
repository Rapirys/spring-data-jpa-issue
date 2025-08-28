# Repro: JPQL `/* ... */` comments break `@Query` in Spring Data JPA (Boot 3.5.x)

Minimal project reproducing a regression where JPQL-style comments inside `@Query` methods stop working after upgrading to Spring Boot **3.5.5** (Spring Data JPA matching that line). The same code works on Spring Boot **3.3.5**.

## What breaks

A repository method with JPQL comments:

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("""
      SELECT /* Multi-line comment
               spanning multiple lines */ u
      FROM User u
      WHERE /* Inline comment */ u.email IS NOT NULL
      """)
  List<User> findUsersWithEmail();
}

Issue: https://github.com/spring-projects/spring-data-jpa/issues/3997
