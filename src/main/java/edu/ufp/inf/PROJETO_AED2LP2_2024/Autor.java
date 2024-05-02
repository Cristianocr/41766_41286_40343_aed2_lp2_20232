package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.Objects;

public class Autor {
    private String name;
    private String shortName;
    private String scientificName;
    private String affiliation;
    private String orcid;
    private String scienceId;
    private String googleScholarId;
    private String scopusAuthorId;

    public Autor(String name, String shortName, String scientificName, String affiliation, String orcid, String scienceId, String googleScholarId, String scopusAuthorId) {
        this.name = name;
        this.shortName = shortName;
        this.scientificName = scientificName;
        this.affiliation = affiliation;
        this.orcid = orcid;
        this.scienceId = scienceId;
        this.googleScholarId = googleScholarId;
        this.scopusAuthorId = scopusAuthorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getScienceId() {
        return scienceId;
    }

    public void setScienceId(String scienceId) {
        this.scienceId = scienceId;
    }

    public String getGoogleScholarId() {
        return googleScholarId;
    }

    public void setGoogleScholarId(String googleScholarId) {
        this.googleScholarId = googleScholarId;
    }

    public String getScopusAuthorId() {
        return scopusAuthorId;
    }

    public void setScopusAuthorId(String scopusAuthorId) {
        this.scopusAuthorId = scopusAuthorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(name, autor.name) && Objects.equals(shortName, autor.shortName) && Objects.equals(scientificName, autor.scientificName) && Objects.equals(affiliation, autor.affiliation) && Objects.equals(orcid, autor.orcid) && Objects.equals(scienceId, autor.scienceId) && Objects.equals(googleScholarId, autor.googleScholarId) && Objects.equals(scopusAuthorId, autor.scopusAuthorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortName, scientificName, affiliation, orcid, scienceId, googleScholarId, scopusAuthorId);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", orcid='" + orcid + '\'' +
                ", scienceId='" + scienceId + '\'' +
                ", googleScholarId='" + googleScholarId + '\'' +
                ", scopusAuthorId='" + scopusAuthorId + '\'' +
                '}';
    }
}
