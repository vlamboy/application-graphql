package de.example.applicationgraphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConferenceService {

    public Conference updateConference(Conference conferenceFoundById, Conference conference ){
        conferenceFoundById.setConferenceName(conference.getConferenceName());
        conferenceFoundById.setConferenceDescription(conference.getConferenceDescription());
        conferenceFoundById.setConferenceLocation(conference.getConferenceLocation());
        return conferenceFoundById;
    }

    public Conference partialUpdateConference(Conference conferenceById,
                                              ConferenceInput conference) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> conferenceByIdMap =
                mapper.convertValue(conferenceById, Map.class);
        Map<String, Object> conferenceInputMap =
                mapper.convertValue(conference, Map.class);

        for (String key : conferenceInputMap.keySet()) {
            if (conferenceInputMap.get(key) != null) {
                conferenceByIdMap.put(key, conferenceInputMap.get(key));
            }
        }
        var updatedConference = mapper.convertValue(conferenceByIdMap, Conference.class);
        return updatedConference;
    }



}
