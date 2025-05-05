
public class Autovelox {
    private final String comune, provincia, regione, nome;
    private final String annoInserimento, dataEOra, identificatore, latitudine, longitudine;

    public Autovelox(String[] campi) {
        this.comune = campi[0];
        this.provincia = campi[1];
        this.regione = campi[2];
        this.nome = campi[3];
        this.annoInserimento = campi[4];
        this.dataEOra = campi[5];
        this.identificatore = campi[6];
        this.latitudine = campi[7];
        this.longitudine = campi[8];
    }

    public String getIdentificatore(){

        return identificatore;

    }

    public String[] toArray() {
        return new String[]{
            comune, provincia, regione, nome,
            annoInserimento, dataEOra, identificatore,
            latitudine, longitudine
        };
    }

    @Override
    public String toString() {
        return  "Regione: " + regione + "\r\n" +
                "Comune: " + comune + "\r\n" +
                "Provincia: " + provincia + "\r\n" +
                "Nome: " + nome + "\r\n" +
                "Anno Inserimento: " + annoInserimento + "\r\n" +
                "Data e Ora: " + dataEOra + "\r\n" +
                "Identificatore: " + identificatore + "\r\n" +
                "Latitudine: " + latitudine + "\r\n" +
                "Longitudine: " + longitudine + "\r\n" +
                "-----------------------------\r\n";
    }

    public static String header() {
        return "=== INFORMAZIONI AUTOVELOX ===\r\n";
    }

}

