package inventory.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import inventory.model.InhousePart;
import inventory.model.Part;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PartTest {

    private Part part;
    @BeforeEach
    void setUp() {
        part = new Part(1, "name", 12, 100, 1, 10) {};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPartId() {
        assert Objects.equals(part.getPartId(),1);
    }

    @Test
    void getName() {
        assert Objects.equals(part.getName(),"name");
    }

    @Test
    void getPrice() {
        assert Objects.equals(part.getPrice(),12);
    }

    @Test
    void getInStock() {
        assert Objects.equals(part.getInStock(),100);
    }

    @Test
    void getMin() {
        assert Objects.equals(part.getMin(),1);
    }

    @Test
    void getMax() {
        assert Objects.equals(part.getMin(),10);
    }

    @Test
    void setPartId() {
    }

    @Test
    void setName() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void setInStock() {
    }

    @Test
    void setMin() {
    }

    @Test
    void setMax() {
    }

    @Test
    void isValidPart() {
    }

    @Test
    void testToString() {
    }
}