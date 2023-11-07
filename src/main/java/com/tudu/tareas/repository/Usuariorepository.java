package com.tudu.tareas.repository;

import com.tudu.tareas.entities.Tarea;
import com.tudu.tareas.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface Usuariorepository extends CrudRepository<Usuario, Long> {
}
