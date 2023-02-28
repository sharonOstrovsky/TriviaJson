package com.example.triviadto.repository;

import com.example.triviadto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query(value = "SELECT u.* FROM Usuario u WHERE u.id = ?1", nativeQuery = true)
    Usuario traer(Long id);
}

