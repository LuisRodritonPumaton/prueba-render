package com.gestion.apigestionentidad.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_entidad")
@Data
public class Entidad {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", nullable = false, length = 11)
    private Long idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento_fk", referencedColumnName = "id_tipo_documento")
    @OnDelete(action = OnDeleteAction.CASCADE)
    TipoDocumento tipoDocumento;

    @Column(name = "nro_documento", nullable = false, length = 25)
    private String nroDocumento;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "nombre_comercial", nullable = true, length = 100)
    private String nombreComercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente_fk", referencedColumnName = "id_tipo_contribuyente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    TipoContribuyente tipoContribuyente;

    @Column(name = "direccion", nullable = true, length = 250)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 50)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

}
