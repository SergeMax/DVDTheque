package Model;

public class Film {

    private Integer numFilm;
    private String nomFilm;
    private Integer anneeFilm;
    private Integer noteFilm;
    private String resumeFilm;
    private String imageFilm;
    private String realisateurFilm;
    private String nationaliteFilm;

    public Film(){
         numFilm = 1;
       nomFilm= "5eme Element";
        anneeFilm = 2002;
       noteFilm =5;
        resumeFilm ="resumeokerifkero oerpvkoeprkv oeprk porkv koper kpor kpor kpoer kpoerkpoek iojoi tok  otkrto^k rt" +
                "ep okepo tkto kporkt^pokrt krtpo^pok rtpokoprktotkortôtr ";
        imageFilm ="klerfk";
        realisateurFilm ="oijk";
         nationaliteFilm ="okpklm";
    }

    public Film(int numFilm, String nomFilm, int anneeFilm, int noteFilm, String resumeFilm, String imageFilm, String realisateurFilm, String nationaliteFilm) {
        this.numFilm = numFilm;
        this.nomFilm = nomFilm;
        this.anneeFilm = anneeFilm;
        this.noteFilm = noteFilm;
        this.resumeFilm = resumeFilm;
        this.imageFilm = imageFilm;
        this.realisateurFilm = realisateurFilm;
        this.nationaliteFilm = nationaliteFilm;
    }

    public Integer getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(Integer numFilm) {
        this.numFilm = numFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public Integer getAnneeFilm() {
        return anneeFilm;
    }

    public void setAnneeFilm(Integer anneeFilm) {
        this.anneeFilm = anneeFilm;
    }

    public Integer getNoteFilm() {
        return noteFilm;
    }

    public void setNoteFilm(Integer noteFilm) {
        this.noteFilm = noteFilm;
    }

    public String getResumeFilm() {
        return resumeFilm;
    }

    public void setResumeFilm(String resumeFilm) {
        this.resumeFilm = resumeFilm;
    }

    public String getImageFilm() {
        return imageFilm;
    }

    public void setImageFilm(String imageFilm) {
        this.imageFilm = imageFilm;
    }

    public String getRealisateurFilm() {
        return realisateurFilm;
    }

    public void setRealisateurFilm(String realisateurFilm) {
        this.realisateurFilm = realisateurFilm;
    }

    public String getNationaliteFilm() {
        return nationaliteFilm;
    }

    public void setNationaliteFilm(String nationaliteFilm) {
        this.nationaliteFilm = nationaliteFilm;
    }
}


