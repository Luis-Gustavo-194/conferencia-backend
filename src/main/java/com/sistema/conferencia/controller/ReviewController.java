package com.sistema.conferencia.controller;

import com.sistema.conferencia.domain.Revision;
import com.sistema.conferencia.repository.RevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private RevisionRepository revisionRepository;

    @PostMapping("/crear")
    public Revision crearRevision(@RequestBody Revision revision) {
        revision.setFechaEnvio(LocalDateTime.now());
        return revisionRepository.save(revision);
    }
}
