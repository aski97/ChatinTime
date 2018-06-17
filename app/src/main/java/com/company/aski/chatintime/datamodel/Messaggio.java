package com.company.aski.chatintime.datamodel;

class Messaggio {

    private enum TipoMessaggio {TESTO, AUDIO, IMMAGINE };

    private String idMittente;
    private String idMessaggio; //lo crea firebase ogni volta che è creato
    private String idDestinatario; //nel caso in cui si volesse rispondere ad un messaggio (da implementare in futuro)
    private String dataInvio;
    private TipoMessaggio tipoMessaggio;
    private String testoMessaggio;
    private String nomeCognomeMittente; //si deve vedere se è possibile recuperarlo dall'idMittente

    public Messaggio() {
    }
}
