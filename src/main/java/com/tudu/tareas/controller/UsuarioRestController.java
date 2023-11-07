package com.tudu.tareas.controller;

import com.tudu.tareas.entities.Tarea;
import com.tudu.tareas.entities.Usuario;
import com.tudu.tareas.repository.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping( path = "/usuario" )
public class UsuarioRestController {
    @Autowired
    private Usuariorepository usuariorepository;

    @GetMapping
    public Iterable<Usuario> getAllUsuarios() {
        return usuariorepository.findAll();
    }

    @GetMapping( path = "/{id}" )
    public Usuario getUsuarioById(@PathVariable long id) {
        Optional<Usuario> usuario = usuariorepository.findById(id);
        return usuario.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        boolean isOk = true;
        if (usuario == null)
            return ResponseEntity.badRequest().build();

        if (    usuario.getUsuario() == null || usuario.getPassword() == null ||
                usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty() ) {
            isOk = false;
        }

        if ( isOk ){
            Usuario saved = usuariorepository.save(usuario);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable long id) {
        Optional<Usuario> usuarioIndb = usuariorepository.findById(id);

        if (usuarioIndb.isEmpty())
            return ResponseEntity.notFound().build();

        usuario.setIdUsuario( usuarioIndb.get().getIdUsuario() );

        boolean isOk = true;
        if (usuario == null)
            return ResponseEntity.badRequest().build();

        if (   usuario.getPassword() == null || usuario.getPassword().isEmpty() ) {
            isOk = false;
        }

        if ( isOk ){
            Usuario saved = usuariorepository.save(usuario);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id) {
        Optional<Usuario> usuarioInDb = usuariorepository.findById(id);

        if ( usuarioInDb.isEmpty() ) {
            return ResponseEntity.badRequest().build();
        }
        usuariorepository.deleteById(id);

        return ResponseEntity.ok( usuarioInDb.get() );
    }



}
