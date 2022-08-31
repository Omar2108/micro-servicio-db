/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omar.microDB.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Omar Rodriguez
 * @version 1.0.0
 */


@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    
    private String apellidos;
    
    @Column(unique=true)
    private Long cedula;

    private String email;
    
    @OneToOne
    @JoinColumn(name = "celular_id")
    private Celular celular;

    

    public void setEmail(String email) throws Exception {
        if (!email.contains("@")) {
            throw new Exception("El formato del email utilizado es invalido");
            
        }
        this.email = email;
    }

}
