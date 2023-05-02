package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class InventoryServiceUnitarTest {

    private static InventoryRepository mockRepo;
    private static InventoryService service;

    @BeforeEach
    void setUp() {
//        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
//        mockRepo.addPart(p1);
    }

    @AfterEach
    void setUpAfter() {
//        if(mockRepo.getAllParts().size()>1)
//        {
//            mockRepo.deletePart(mockRepo.getAllParts().get(1));
//            mockRepo.deletePart(mockRepo.getAllParts().get(0));
//
//        }
//        else if(mockRepo.getAllParts().size()==1){
//            mockRepo.deletePart(mockRepo.getAllParts().get(0));
//        }
    }

    @BeforeAll
    static void addMock() {
        mockRepo = mock(InventoryRepository.class);
        service = new InventoryService(mockRepo);
    }


    @AfterEach
    void tearDown() {
    }

    /*
     private int partId;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;
     */
    @Test
    void addInhousePartValid() {
        Part p1 = new InhousePart(1, "Valid name of part", 12, 10, 2, 20, 1);
        Mockito.doNothing().when(mockRepo).addPart(p1);
        Mockito.when(mockRepo.getAllParts()).thenReturn(FXCollections.observableArrayList(p1));
        assert (service.getAllParts().size() == 1);
        assert (service.getAllParts().get(0).equals(p1));

    }

    @Test
    void addInhousePartInvalid() {
        Part p2 = new InhousePart(-1, "", -12, -10, 2, 20, 1);
        Mockito.doNothing().when(mockRepo).addPart(p2);
        Mockito.when(mockRepo.getAllParts()).thenReturn(FXCollections.observableArrayList());
        assert (service.getAllParts().size()==0);

    }




    @Test
    void addInhousePart() {
        Part p2 = new InhousePart(1, "Important part", 12, 10, 2, 20, 1);
        Mockito.doNothing().when(mockRepo).addPart(p2);
        Mockito.when(mockRepo.getAllParts()).thenReturn(FXCollections.observableArrayList(p2));
        assert (service.getAllParts().size()==1);
        assert (service.getAllParts().get(0).equals(p2));


    }



    @Test
    void filterPart() throws Exception {
        Part p1 = new InhousePart(1, null, 2, 10, 5, 4, 1);
        Mockito.when(mockRepo.getAllParts()).thenReturn(FXCollections.observableArrayList(p1));
        assert (service.filterPart(5,4).size()==0);

    }


    }

