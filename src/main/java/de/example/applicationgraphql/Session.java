package de.example.applicationgraphql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session {

    private Integer id;
    private String sessionName;
    private String sessionDescription;
    private List<Integer> speakerIds;
    private Boolean sessionRecorded;
    private String conferenceId;

    public Session(Integer id, String sessionName, String sessionDescription, List<Integer> speakerIds, Boolean sessionRecorded, String conferenceId) {
        this.id = id;
        this.sessionName = sessionName;
        this.sessionDescription = sessionDescription;
        this.speakerIds = speakerIds;
        this.sessionRecorded = sessionRecorded;
        this.conferenceId = conferenceId;
    }

    private static List<Integer> speakers = Arrays.asList(1,2,3);

    private static List<Session> sessions = Arrays.asList(
            new Session(1,
                    "How to not use Comic Sans",
                    "We show how to use good fonts.",
                    speakers,
                    true, "1"),
            new Session(2,
                    "Why serifs are old fashioned",
                    "See in this session what modern font really look like.",
                    speakers,
                    true, "1")
    );

    public static Session getById(String id) {
        return sessions.stream().filter(session -> session.getId().equals(id)).findFirst().orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public List<Integer> getSpeakerIds() {
        return speakerIds;
    }

    public void setSpeakerIds(List<Integer> speakerIds) {
        this.speakerIds = speakerIds;
    }

    public Boolean getSessionRecorded() {
        return sessionRecorded;
    }

    public void setSessionRecorded(Boolean sessionRecorded) {
        this.sessionRecorded = sessionRecorded;
    }

    public static List<Session> getSessions() {
        return sessions;
    }

    public static void setSessions(List<Session> sessions) {
        Session.sessions = sessions;
    }
}
