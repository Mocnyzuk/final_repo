package io.restApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.data.PredictionRepository;
import io.restApp.model.Prediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PredictionService {

    public final String GET_MAP_INFO_ON_ADD = "Prepare a HTTPPOST with new prediction details as JSON";
    public final String DELETION_SUCCES = "Delete success";
    public final String DELETION_FAILURE = "Delete failed";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private PredictionRepository predictionRepository;

    @Autowired
    public PredictionService(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    public List<Prediction> getAllPredictions(){
        List<Prediction> resultList = predictionRepository.findAll();
        try {
            log.debug(OBJECT_MAPPER.writeValueAsString(resultList));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return resultList;
    }
    public Prediction getOneById(Long id){
        Prediction result = predictionRepository.findById(id).orElse(
                new Prediction("No such prediction", "wrong id"));
        try {
            log.debug(OBJECT_MAPPER.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return result;
    }
    public boolean createNew(String json){
        Prediction prediction = new Prediction("something went wrong", "try again");
        try {
            prediction = OBJECT_MAPPER.readValue(json,
                    Prediction.class);
            if(String.valueOf(prediction.getSentence()).equals("null")||
                    String.valueOf(prediction.getAuthor()).equals("null")){
                log.debug("DID NOT SAVE TO THE PREDICTION REPO");
                return false;
            }

        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        predictionRepository.save(prediction);
        log.debug("SAVE COMPLETED THE PREDICTION");
        return true;
    }

    public Prediction getRandomPrediction() {
        List<Prediction> list = predictionRepository.findAll();
        int size = list.size();
        Random random = new Random();
        Prediction result = list.get(random.nextInt(size));
        try {
            log.debug(OBJECT_MAPPER.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return result;
    }
    public Prediction updatePredicton(Long id, String json){
        Prediction prediction;
        try {
            prediction = OBJECT_MAPPER.readValue(json,
                    Prediction.class);
            predictionRepository.updateExistingPrediction(prediction.getSentence(),
                    prediction.getAuthor(), id.toString());
            log.debug(OBJECT_MAPPER.writeValueAsString(prediction));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return predictionRepository.findById(id).orElse(
                new Prediction("Wrong syntax of JSON", ""));
    }
    public boolean deleteById(Long id) {
        Prediction prediction = getOneById(id);
        if (prediction.getId() != null) {
            predictionRepository.deleteById(id);
            log.debug("DELETION COMPLETED GIVEN PREDICTION");
            return true;
        }
        log.debug("DELETION FAILED GIVEN PREDICTION");
        return false;
    }
}
