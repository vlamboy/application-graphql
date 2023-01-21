package de.example.applicationgraphql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Conference {

    @Id
    @GeneratedValue
    private Integer id;
    private String conferenceName;
    private String conferenceDescription;
    private String conferenceLocation;


    public Conference(Integer id, String conferenceName, String conferenceDescription, String conferenceLocation, List<Integer> sessionIds) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.conferenceLocation = conferenceLocation;
    }

    private static List<Integer> sessions = new ArrayList<>(Arrays.asList(1, 2));


    public Conference() {

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

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", conferenceName='" + conferenceName + '\'' +
                ", conferenceDescription='" + conferenceDescription + '\'' +
                ", conferenceLocation='" + conferenceLocation + '\'' +
                '}';
    }
}
