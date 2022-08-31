package com.omar.microDB;

import com.omar.microDB.bean.output.Respuesta;
import com.omar.microDB.controllers.MainController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroDbApplicationTests {

    private MainController main;

    @Test
    void contextLoads() {
    }
    
    void addUser() throws Exception{
        Respuesta res = main.addNewUser("John", "jhon@gmail.com", "perez", Long.MIN_VALUE);
      assertThat(res.getError()).isNotNull();
    }

}
