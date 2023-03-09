package com.prosoft.repository;

import com.prosoft.domain.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Интерфейс UserAccessRepository содержит методы работы с доступами пользователей
 */
@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    List<UserAccess> findByLogin(String login);

}
