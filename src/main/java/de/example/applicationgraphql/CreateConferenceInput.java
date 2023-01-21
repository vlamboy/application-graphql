package de.example.applicationgraphql;

public class CreateConferenceInput {
    public String conferenceName;

    public CreateConferenceInput(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
}
