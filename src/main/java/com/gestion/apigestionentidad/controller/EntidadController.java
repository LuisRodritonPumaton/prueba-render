
package com.gestion.apigestionentidad.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.apigestionentidad.model.Entidad;
import com.gestion.apigestionentidad.services.EntidadService;

@RestController
@RequestMapping("api/entidad")
public class EntidadController{
    
    @Autowired
    private EntidadService entidadService;


    @GetMapping("/lista")
    public JSONObject listarEntidad() throws Exception{
        try{
            HashMap<String, List<Entidad>> map = new HashMap<>();
            map.put("data", entidadService.listarEntidad());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @PostMapping("/registrar_entidad")
    public JSONObject registrar_entidad(@RequestBody Entidad entidad) throws Exception{
        try{
            HashMap<String, Entidad> map = new HashMap<>();
            map.put("data", entidadService.registrarEntidad(entidad));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @PutMapping("/actualizar_entidad")
    public JSONObject actualizar_entidad(@RequestBody Entidad entidad) throws Exception{
        try{
            HashMap<String, Entidad> map = new HashMap<>();
            map.put("data", entidadService.actualizarEntidad(entidad));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @DeleteMapping("/{id_entidad}")
    public JSONObject eliminar_entidad(@PathVariable("id_entidad") Long id_entidad) throws Exception{
        try{
            HashMap<String, Entidad> map = new HashMap<>();
            map.put("data", entidadService.eliminarEntidad(id_entidad));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }



}
