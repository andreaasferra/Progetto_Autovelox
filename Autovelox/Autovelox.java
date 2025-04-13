public class Autovelox {
    private String comune;
    private String provincia;
    private String regione;
    private String nome;
    private String anno;
    private String data;
    private String identificatore;
    private double latitudine;
    private double longitudine;
   

    
    public Autovelox(String comune, String provincia, String regione, String nome, String anno, String data, String identificatore, double latitudine, double longitudine) {
        this.comune = comune;
        this.provincia = provincia;
        this.regione = regione;
        this.nome = nome;
        this.anno = anno;
        this.data = data;
        this.identificatore = identificatore;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
       
    }
    // Getter e setter
    public String getComune() {
        return comune;
    }
    public void setComune(String comune) {
        this.comune = comune;
    }   

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }
    public void setRegione(String regione) {
        this.regione = regione;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAnno() {
        return anno;
    }
    public void setAnno(String anno) {
        this.anno = anno;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getIdentificatore() {
        return identificatore;
    }
    public void setIdentificatore(String identificatore) {
        this.identificatore = identificatore;
    }
    public double getLatitudine() {
        return latitudine;
    }
    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }
    public double getLongitudine() {
        return longitudine;
    }
    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }
    @Override
    public String toString() {
        return "Autovelox [Comune=" + comune + ", Provincia=" + provincia +
                ", Latitudine=" + latitudine + ", Longitudine=" + longitudine +
                ", Nome=" + nome + ", Anno=" + anno + ", Data=" + data +
                ", Identificatore=" + identificatore + "]";
    }
}
