package io.restApp.data;

import io.restApp.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE prediction SET sentence = (:sent), author = (:auth) WHERE id = (:number)")
    void updateExistingPrediction(@Param("sent")String sent,
                                  @Param("auth")String auth,
                                  @Param("number")String number);
}
