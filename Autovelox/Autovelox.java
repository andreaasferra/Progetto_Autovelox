
public class Autovelox{

    final private String comune;
    final private String provincia;
    final private String regione;
    final private String nome;
    final private String anno;
    final private String data;
    final private String identificatore;
    final private String longitudine;
    final private String latitudine;

    public Autovelox( String comune, String provincia, String regione, String nome, String anno, String data, String identificatore,  String longitudine, String latitudine){

        this.comune = comune;
        this.provincia = provincia;
        this.regione = regione;
        this.nome = nome;
        this.anno = anno;
        this.data = data;
        this.identificatore = identificatore;
        this.longitudine = longitudine;
        this.latitudine = latitudine;

    }

    @Override

    public String toString(){

            return "\nComune: " +comune + "\nProvincia " + provincia + "\nRegione " + regione + "\nNome: " + nome + "\nAnno: "  + anno + "\nData "  + data + "\nIdentificatore: " + identificatore + "\nLongitudine " + longitudine + "\nLatitudine " + latitudine;

    }

}