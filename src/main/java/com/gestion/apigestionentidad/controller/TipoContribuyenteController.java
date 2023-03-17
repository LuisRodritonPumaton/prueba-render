package com.gestion.apigestionentidad.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.apigestionentidad.model.TipoContribuyente;
import com.gestion.apigestionentidad.model.Usuario;
import com.gestion.apigestionentidad.services.TipoContribuyenteService;
import com.gestion.apigestionentidad.services.UsuarioSerive;

@RestController
@RequestMapping("api/tipo_contribuyente")
public class TipoContribuyenteController {
    @Autowired
    private TipoContribuyenteService tipoContribuyenteService;
    @Autowired
    private UsuarioSerive usuarioSerive;
    @GetMapping("/lista")
    public JSONObject listarTipoContribuyente() throws Exception{
        try{
            HashMap<String, List<TipoContribuyente>> map = new HashMap<>();
            map.put("data", tipoContribuyenteService.listarTipoContribuyente());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @PostMapping("/registrar_tipo_contribuyente")
    public JSONObject registrar_tipo_contribuyente(@RequestBody TipoContribuyente tipoContribuyente) throws Exception{
        try{
            HashMap<String, TipoContribuyente> map = new HashMap<>();
            map.put("data", tipoContribuyenteService.registrarTipoContribuyente(tipoContribuyente));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }
    @PostMapping("/registrar_usuario")
    public Usuario registrar_tipo_contribuyente(@RequestBody Usuario tipoContribuyente) throws Exception{
        Usuario usuarioLocal = tipoContribuyente;
        usuarioLocal.setPassword(new BCryptPasswordEncoder().encode(usuarioLocal.getPassword()));
        usuarioSerive.registrarUsuario(usuarioLocal);
        return usuarioLocal;
    }
    @PutMapping("/actualizar_tipo_contribuyente")
    public JSONObject actualizar_tipo_contribuyente(@RequestBody TipoContribuyente tipoContribuyente) throws Exception{
        try{
            HashMap<String, TipoContribuyente> map = new HashMap<>();
            map.put("data", tipoContribuyenteService.actualizarTipoContribuyente(tipoContribuyente));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @DeleteMapping("/{id_tipo_contribuyente}")
    public JSONObject eliminar_entidad(@PathVariable("id_tipo_contribuyente") Long id_tipo_contribuyente) throws Exception{
        try{
            HashMap<String, TipoContribuyente> map = new HashMap<>();
            map.put("data", tipoContribuyenteService.eliminarTipoContribuyente(id_tipo_contribuyente));
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }catch(Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());
            JSONObject jsonpObject = new JSONObject(map);
            return jsonpObject;
        }
    }

    @GetMapping("/{id_tipo_contribuyente}")
    public TipoContribuyente obtener_tipo_contribuyente_por_id(@PathVariable("id_tipo_contribuyente") Long id_tipo_contribuyente) throws Exception{
        return tipoContribuyenteService.obtenerTipoContribuyentePorId(id_tipo_contribuyente);
    }
}
