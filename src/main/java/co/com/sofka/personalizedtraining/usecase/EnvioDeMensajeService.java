package co.com.sofka.personalizedtraining.usecase;

public interface EnvioDeMensajeService {
    Boolean enviarMensaje(String EmailDestino, String asunto, String cuerpo);
}
