# Progetto_Autovelox
Introduzione del codice:

Questo progetto consiste nell'estrapolare le informazioni di un file CSV, corrispondenti a tutti gli autovelox presenti in Italia, in una struttura dati.
La struttura dati da me scelta è un ArrayList ed il motivo di questa scelta sono state le proprietà di essa, tra queste l'aumentare della memoria che a sua volta si estende mano a mano che vengono inserite le informazioni, rendendo una scelta flessibile nel caso in cui volessi caricare piu informazioni come in questo file CSV;

Nel progetto, il server gestisce le richieste dei client attraverso una connessione TCP stabilita mediante Socket, ovvero una combinazione tra indirizzo IP e porta, che permette di stabilire la connessione tra client e server. 
Dopo che la connessione è stabilita, client e server possono scambiarsi messaggi attraverso il socket ed il protocollo TCP garantisce che tutti i dati inviati dal client vengano ricevuti correttamente dal server (e viceversa).

Avviato il progetto l'utente può decidere se visualizzare tutto il contenuto del file CSV, una sola riga o colonna del file.
In aggiunta ho scelto di agevolare l'esperienza dell'utente aggiungendo una ricerca tramite il parametro più intuitivo tra tutti quelli presenti nel file, ovvero l'identificatore.

Le istruzioni per avviare l'applicazioni sono semplici e intuitive:

1. Avviare la classe server in modo da stabilirci una connessione;
2. Aprire il terminale e scegliere l'indirizzo di localhost (127.0.0.1) e la porta assegnata al server (1050);
3. Una volta dentro, grazie alla classe client che termina lo sviluppo della trasmissione, all'utente viene proposto un breve "menù" che racchiude le funzionalità dell'applicazione;
4. Una volta terminato l'uso dell'applicazione digitare 'QUIT' per terminare la connessione tra client e server.

Nella relazione verranno riportate le classi utilizzate, insieme ai comandi e le gestioni efficenti degli errori di trasmissione.