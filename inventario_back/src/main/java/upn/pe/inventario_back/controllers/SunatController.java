package upn.pe.inventario_back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upn.pe.inventario_back.services.ConsultaRucService;

@RestController
@RequestMapping("/api/sunat")
public class SunatController {

    private final ConsultaRucService consultaRucService;

    public SunatController(ConsultaRucService consultaRucService) {
        this.consultaRucService = consultaRucService;
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<?> consultarRuc(@PathVariable String ruc) {
        try {
            String resultado = consultaRucService.consultarRuc(ruc);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar la API de SUNAT", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}