package de.example.applicationgraphql;

public class ConferenceInput {
    public String conferenceName;
    public String conferenceDescription;
    public String conferenceLocation;

    public ConferenceInput(String conferenceName, String conferenceDescription, String conferenceLocation) {
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.conferenceLocation = conferenceLocation;
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
}
