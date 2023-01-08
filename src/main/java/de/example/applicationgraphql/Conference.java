package de.example.applicationgraphql;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conference {

    private Integer id;
    private String conferenceName;
    private String conferenceDescription;
    private String conferenceLocation;
    private List<Integer> sessionIds;

    public Conference(Integer id, String conferenceName, String conferenceDescription, String conferenceLocation, List<Integer> sessionIds) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.conferenceLocation = conferenceLocation;
        this.sessionIds = sessionIds;
    }

    private static List<Integer> sessions = new ArrayList<>(Arrays.asList(1,2));

    private static List<Conference> conferences = Arrays.asList(
            new Conference(1,
                    "Typo Conference",
                    "The Conference for Typography lovers.",
                    "München",
                    sessions)
    );

    public static Conference getById(Integer id) {
            return conferences.stream().filter(conference -> conference.getId().equals(id))
                    .findFirst().orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceDescription() {
        return conferenceDescription;
    }

    public void setConferenceDescription(String conferenceDescription) {
        this.conferenceDescription = conferenceDescription;
    }

    public String getConferenceLocation() {
        return conferenceLocation;
    }

    public void setConferenceLocation(String conferenceLocation) {
        this.conferenceLocation = conferenceLocation;
    }

    public List<Integer> getSessionIds() {
        return sessionIds;
    }

    public void setSessionIds(ArrayList<Integer> sessionId) {
        this.sessionIds = sessionIds;
    }
}
