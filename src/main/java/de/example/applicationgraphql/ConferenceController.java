package de.example.applicationgraphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


@Controller
public class ConferenceController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    ConferenceService conferenceService;

    @QueryMapping //binds this method to a query
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @QueryMapping
    public Conference conferenceById(@Argument Integer id) throws ResourceNotFoundException {
        var conferenceFoundById =  conferenceRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Conference with id " + id + " does not exist."));
        return conferenceFoundById;
    }

    @MutationMapping
    public Conference createConference(@Argument Conference conference) {
        return conferenceRepository.save(conference);
    }

    @MutationMapping
    public ResponseEntity deleteConference(@Argument Integer id){
        var foundConference = conferenceRepository.findById(id);
        conferenceRepository.deleteById(id);
        return ResponseEntity.ok(foundConference);
    }

    @MutationMapping
    public void updateConference(@Argument Integer id, @Argument Conference conference) throws ResourceNotFoundException {
        Conference conferenceFoundById = conferenceRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Conference with id " + id + " does not exist."));;
       Conference updatedConference = conferenceService.updateConference(conferenceFoundById, conference);
       conferenceRepository.save(updatedConference);
    }

    @MutationMapping
    public void partialUpdateConference(@Argument Integer id, @Argument ConferenceInput conference) {

        Conference conferenceById = conferenceRepository.findById(id).get();
        Conference updatedConference = conferenceService.partialUpdateConference(conferenceById, conference);
        conferenceRepository.save(updatedConference);
    }

//    @SchemaMapping //maps controller method to a field in the schema + declares it to be the DataFetcher for that field
//    public Session session (Conference conference){
//        return Session.getById(conference.getSessionIds().get(1));
//    }
}
