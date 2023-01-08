package de.example.applicationgraphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ConferenceController {

    @QueryMapping //binds this method to a query
    public Conference conferenceById(@Argument Integer id){
        return Conference.getById(id);
    }

    @SchemaMapping //maps controller method to a field in the schema + declares it to be the DataFetcher for that field
    public Session session (Conference conference){
        return Session.getById(conference.getSessionIds().get(1));
    }
}
