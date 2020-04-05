package io.restApp.controller;

import io.restApp.model.Prediction;
import io.restApp.service.PredictionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prediction")
public class PredictionController {

    private PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }
    @GetMapping
    public Prediction getRandom(){
        return predictionService.getRandomPrediction();
    }

    @GetMapping("/all")
    public List<Prediction> getAll(){
        return predictionService.getAllPredictions();
    }
    @GetMapping("/{id}")
    public Prediction getOneById(@PathVariable Long id){
        return predictionService.getOneById(id);
    }
    @PutMapping("/{id}")
    public Prediction updateOneById(@PathVariable Long id,
                                    @RequestBody String json){
        return predictionService.updatePredicton(id, json);
    }
    @GetMapping("/add")
    public String createPrediction(){
        return predictionService.GET_MAP_INFO_ON_ADD;
    }
    @PostMapping("/add")
    public Prediction createNewPrediction(@RequestBody String json){
        long id = 1L;
        if(predictionService.createNew(json)) {
            id = predictionService.getAllPredictions().size();
        }
        return getOneById(id);
    }
    @DeleteMapping("/{id}")
    public String deletePrediction(@PathVariable Long id){
        return (predictionService.deleteById(id))?predictionService.DELETION_SUCCES:predictionService.DELETION_FAILURE;
    }

}
