package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import inventory.model.Part;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    private static InventoryRepository mockRepo;
    private static InventoryRepository inventory;
    private static InventoryRepository repository;
    private static InventoryService service;

    private static List<Part> partList = new ArrayList<>();
    private static Part mockPart;


    @BeforeEach
    void setUp(){
        mockRepo = new InventoryRepository();
        repository = new InventoryRepository();
        inventory = new InventoryRepository();
        partList = new ArrayList<>();


    }
    @Test
    void addInhousePart() {
        setUp();
        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
        inventory = mock(InventoryRepository.class);
        Mockito.doNothing().when(inventory).addPart(p1);
        Mockito.when(inventory.getAllParts()).thenReturn(FXCollections.observableArrayList(p1));
        System.out.println(inventory.getAllParts().size());
        assert (inventory.getAllParts().size()==1);
    }

    @Test
    void lookupPart() {
        setUp();
        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
        inventory = mock(InventoryRepository.class);
        Mockito.when(inventory.lookupPart("Valid name of part")).thenReturn(p1);

        assert (inventory.lookupPart("Valid name of part")==p1);
    }


    @Test
    void repoIntegrationStep2Add() {
        setUp();
       repository = new InventoryRepository();
        mockPart = mock(Part.class);
        repository.addPart(mockPart);
        service = new InventoryService(repository);
        System.out.println(service.getAllParts().size());
        assert (service.getAllParts().size()==19);

    }

    @Test
    void repoIntegrationStep2LookUp() {
        repository = new InventoryRepository();
        mockPart = mock(Part.class);
        repository.addPart(mockPart);
        service = new InventoryService(repository);
        assert(service.lookupPart("b")==null);
    }

    @Test
    void repoIntegrationStep3Add() {
        repository = new InventoryRepository();
        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
        repository.addPart(p1);
        service = new InventoryService(repository);
        System.out.println(service.getAllParts().size());
        assert (service.getAllParts().size()==20);

    }

    @Test
    void repoIntegrationStep3LookUp() {
        repository = new InventoryRepository();
        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
        repository.addPart(p1);
        service = new InventoryService(repository);
        assert(service.lookupPart("b")==null);
    }
}


