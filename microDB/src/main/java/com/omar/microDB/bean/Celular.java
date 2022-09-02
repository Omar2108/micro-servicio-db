
package com.omar.microDB.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author LENOVO
 */

@Entity
@Table(name = "celular")
@Data
public class Celular implements Serializable {
    
    private static final Long serioVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String marca;
    
    private String modelo;
    
  
    @OneToOne(mappedBy = "celular")
    private User user;

    
    
    
    
}
