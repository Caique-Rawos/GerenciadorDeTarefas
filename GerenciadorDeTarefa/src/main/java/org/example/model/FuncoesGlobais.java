package org.example.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Caique Rawos.
 */


/**
 * Esta classe sera usada para criação de funcoes que poderao ser utilizadas por todas as outras classes
 */
public class FuncoesGlobais {

    /**
     * Conversor de LocalDateTime para Epoch (long)
     * @param data valor em LocalDateTime da data desejada
     * @return (long) referente ao epoch da data enviada
     */
    public long dataParaEpoch(LocalDateTime data){
        ZoneId zoneIdDoSistema = ZoneId.systemDefault();
        long epoch = data.atZone(zoneIdDoSistema).toEpochSecond();

        return epoch;
    }

    /**
     *
     * @param epoch long que sera convertido para data
     * @param formato formato de conversao como por exemplo "dd/MM/yyyy HH:mm:ss"
     * @return (String) da data convertida no formato escolhido
     */
    public String epochParaData(long epoch, String formato){
        Instant instant = Instant.ofEpochSecond(epoch);
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        String formattedDateTime = localDateTime.format(formatter);

        return formattedDateTime;
    }
}
