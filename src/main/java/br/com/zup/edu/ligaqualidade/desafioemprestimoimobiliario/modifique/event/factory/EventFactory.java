package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;


public class EventFactory {

    public static Event newEvent(String eventSchema, String eventAction, String ...info) {
        return Schema.getSchema(eventSchema, eventAction).getEvent().newEvent(info);
    }
}
