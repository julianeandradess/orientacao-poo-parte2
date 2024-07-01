package academy.dev.junit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    @Test
    public void intanceOf_ExecutesChildsClassMethod_WhenObjectIsOfChildType(){
        Employee employeeDeveloper = new Developer("1", "Java");
        if (employeeDeveloper instanceof Developer){ //forma antiga
            Developer developer = (Developer) employeeDeveloper; //cached
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }

        if (employeeDeveloper instanceof Developer developer){ //forma nova
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}