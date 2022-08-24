/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omar.microDB;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Omar Rodriguez
 * @version 1.0.0
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
