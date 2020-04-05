package io.restApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.model.Prediction;
import io.restApp.service.PredictionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PredictionControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PredictionService predictionService;
    @Test
    @DisplayName("Should get random prediction")
    @DirtiesContext
    void getRandom() throws Exception{
        //when
        MvcResult result = mockMvc.perform(
                get("/prediction"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Object object = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        //then
        assertTrue(object instanceof Prediction);
    }

    @Test
    @DisplayName("Should return an array of predictions")
    @DirtiesContext
    void getAll() throws Exception{
        //given
        List<Prediction> expected = predictionService.getAllPredictions();
        //when
        MvcResult result = mockMvc.perform(
                get("/prediction/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction[] resultList = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction[].class
        );
        assertArrayEquals(expected.toArray(), resultList);
    }

    @Test
    @DisplayName("Should return one prediction for given id")
    @DirtiesContext
    void getOneById() throws Exception {
        //given
        Long id = 2L;
        Prediction expected = predictionService.getOneById(id);
        //when
        MvcResult result = mockMvc.perform(
                get("/prediction/"+id))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPrediction = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        assertEquals(expected, resultPrediction);
    }
    @Test
    @DisplayName("Should return prediction with info of that the id is wrong")
    @DirtiesContext
    void getOneByIdWithWrongId() throws Exception {
        //given
        Long id = 112333333L;
        Prediction expected = predictionService.getOneById(id);
        //when
        MvcResult result = mockMvc.perform(
                get("/prediction/"+id))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPrediction = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        assertEquals(expected, resultPrediction);
    }

    @Test
    @DisplayName("Should edit the Prediction of given id")
    @DirtiesContext
    void updateOneById() throws Exception {
        //given
        long id = 2L;
        Prediction given = createNewPrediction();
        String jsonOfGiven = OBJECT_MAPPER.writeValueAsString(given);
        given.setId(id);
        //when
        MvcResult result = mockMvc.perform(
                put("/prediction/"+id)
                .content(jsonOfGiven))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPred = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        assertEquals(given, resultPred);
    }

    @Test
    @DisplayName("Should return special info as prediction for wrong index")
    @DirtiesContext
    void updateOneByWrongId() throws Exception {
        //given
        long id = 22222L;
        Prediction given = new Prediction("Wrong syntax of JSON", "");
        String jsonOfGiven = OBJECT_MAPPER.writeValueAsString(given);
        //when
        MvcResult result = mockMvc.perform(
                put("/prediction/"+id)
                        .content(jsonOfGiven))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPred = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        //then
        assertEquals(given, resultPred);
    }

    @Test
    @DisplayName("Should return string with info of Get method on /add url")
    @DirtiesContext
    void createPrediction() throws Exception {
        //given
        String expected = predictionService.GET_MAP_INFO_ON_ADD;
        //when
        MvcResult result = mockMvc.perform(
                get("/prediction/add"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //then
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Should create new Prediction for given JSON")
    @DirtiesContext
    void addNewPrediction()throws Exception {
        //given
        Prediction given = createNewPrediction();
        String jsonOfGiven = OBJECT_MAPPER.writeValueAsString(given);
        //when
        MvcResult result = mockMvc.perform(
                post("/prediction/add")
                        .content(jsonOfGiven))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPred = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        long id = predictionService.getAllPredictions().size();
        given.setId(id);
        //then
        assertEquals(given, resultPred);
    }
    @Test
    @DisplayName("Should doesnt create new Prediction becouse of wrong JSON")
    @DirtiesContext
    void addNewPredictionWithWrongJson()throws Exception {
        //given
        Prediction expected = predictionService.getOneById(1L);
        Prediction given = new Prediction(null,null);
        String jsonOfGiven = OBJECT_MAPPER.writeValueAsString(given);
        //when
        MvcResult result = mockMvc.perform(
                post("/prediction/add")
                        .content(jsonOfGiven))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Prediction resultPred = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), Prediction.class
        );
        long id = predictionService.getAllPredictions().size();
        given.setId(id);
        //then
        assertEquals(expected, resultPred);
    }

    @Test
    @DisplayName("Should return deletion succes")
    @DirtiesContext
    void deletePrediction() throws Exception {
        //given
        long idToDelete = 2L;
        String expected = predictionService.DELETION_SUCCES;
        //when
        MvcResult result = mockMvc.perform(
                delete("/prediction/"+idToDelete))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //then
        assertEquals(expected, result.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Should return deletion failure becouse of wrong index")
    void deletePredictionWithWrongIndex() throws Exception {
        //given
        long idToDelete = 222222L;
        String expected = predictionService.DELETION_FAILURE;
        //when
        MvcResult result = mockMvc.perform(
                delete("/prediction/"+idToDelete))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //then
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    private Prediction createNewPrediction(){
        return new Prediction("Prediction for testing", "tester");
    }
}