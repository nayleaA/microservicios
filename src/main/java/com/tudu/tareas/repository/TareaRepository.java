package com.tudu.tareas.repository;

import com.tudu.tareas.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
}
