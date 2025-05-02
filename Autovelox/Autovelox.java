public class Autovelox {
private String comune, provincia, regione, nome;
    private String annoInserimento, dataEOra, identificatore, latitudine, longitudine;

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

    public String[] toArray() {
        return new String[]{comune, provincia, regione, nome, annoInserimento, dataEOra, identificatore, latitudine, longitudine};
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %-10s %-15s %-15s %-20s %-15s %-10s %-10s",
            comune, provincia, regione, nome, annoInserimento, dataEOra, identificatore, latitudine, longitudine);
    }

    public static String header() {
        return String.format("%-15s %-10s %-10s %-15s %-15s %-20s %-15s %-10s %-10s",
            "COMUNE", "PROVINCIA", "REGIONE", "NOME", "ANNO_INS", "DATA_ORA", "ID", "LAT", "LON");
    }
}
