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

import com.gestion.apigestionentidad.model.TipoDocumento;
import com.gestion.apigestionentidad.services.TipoDocumentoService;

@RestController
@RequestMapping("api/tipo_documento")
public class TipoDocumentoController {
    
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/lista")
    public JSONObject listarTipoDocumento() throws Exception{
        try{
            HashMap<String, List<TipoDocumento>> map = new HashMap<>();
            map.put("data", tipoDocumentoService.listarTipoDocumento());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @PostMapping("/registrar_tipo_documento")
    public JSONObject registrar_tipo_documento(@RequestBody TipoDocumento tipoDocumento) throws Exception{
        try{
            HashMap<String, TipoDocumento> map = new HashMap<>();
            map.put("data", tipoDocumentoService.registrarTipoDocumento(tipoDocumento));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }
    @PutMapping("/actualizar_tipo_documento")
    public JSONObject actualizar_tipo_documento(@RequestBody TipoDocumento tipoDocumento) throws Exception{
        try{
            HashMap<String, TipoDocumento> map = new HashMap<>();
            map.put("data", tipoDocumentoService.actualizarTipoDocumento(tipoDocumento));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @DeleteMapping("/{id_tipo_documento}")
    public JSONObject eliminar_entidad(@PathVariable("id_tipo_documento") Long id_tipo_documento) throws Exception{
        try{
            HashMap<String, TipoDocumento> map = new HashMap<>();
            map.put("data", tipoDocumentoService.eliminarTipoDocumento(id_tipo_documento));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @GetMapping("/{id_tipo_documento}")
    public TipoDocumento obtener_tipo_documento_por_id(@PathVariable("id_tipo_documento") Long id_tipo_documento) throws Exception{
        return tipoDocumentoService.obtenerTipoDocumentoPorId(id_tipo_documento);
    }
}
