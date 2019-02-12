package edu.stanford.protege.webprotegeoptout;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-12
 */
@Repository
public interface OptOutDataRepository extends MongoRepository<OptOutInfo, String> {

}
