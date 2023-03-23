package com.tiendaonline.tiendabackend.repository;

import com.tiendaonline.tiendabackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
