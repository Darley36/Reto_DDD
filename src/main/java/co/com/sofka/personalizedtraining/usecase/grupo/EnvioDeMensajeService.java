package co.com.sofka.personalizedtraining.usecase.grupo;

public interface EnvioDeMensajeService {
    Boolean enviarMensaje(String EmailDestino, String asunto, String cuerpo);
}
