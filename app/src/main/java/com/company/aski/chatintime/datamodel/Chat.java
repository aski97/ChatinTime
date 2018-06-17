package com.company.aski.chatintime.datamodel;

import java.util.List;

public class Chat {
    private String idCreatore;
    private String idDestinatario;
    private String nomeCreatore;
    private String nomeDestinatario;
    private int oraDistruzione;
    private int minutiDistruzione;
    private String dataCreazione;
    private String dataConfermaChat;
    private List<Messaggio> messaggi;

    public Chat() {

    }

    public Chat(String nomeDestinatario, List<Messaggio> messaggi) {
        this.nomeDestinatario = nomeDestinatario;
        this.messaggi = messaggi;
    }

    public String getIdCreatore() {
        return idCreatore;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public String getNomeCreatore() {
        return nomeCreatore;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public int getOraDistruzione() {
        return oraDistruzione;
    }

    public int getMinutiDistruzione() {
        return minutiDistruzione;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public String getDataConfermaChat() {
        return dataConfermaChat;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }
}
