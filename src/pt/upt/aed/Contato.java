package pt.upt.aed;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contato {
    private String name;
    private Date birthDate;
    private String numStr;
    private Contato next;
    private Contato prev;


    /**
     * Construtor do objeto Contato.
     *
     * @param name
     * @param birthDate
     * @param numStr
     */
    public Contato(String name, Date birthDate, String numStr) {
        this.name = name;
        this.birthDate = birthDate;
        this.numStr = numStr;
    }


    /**
     * Retorna o objeto do tipo Contato anterior.
     *
     * @return
     */
    public Contato getPrev() {
        return prev;
    }

    /**
     * Altera o objeto anterior do tipo Contato.
     *
     * @param prev
     */
    public void setPrev(Contato prev) {
        this.prev = prev;
    }

    /**
     * Retorna o objeto do tipo Contato seguinte.
     *
     * @return
     */
    public Contato getNext() {
        return next;
    }

    /**
     * Altera o próximo objeto Contato.
     *
     * @param next
     */
    public void setNext(Contato next) {
        this.next = next;
    }


    /**
     * Retorna o número de telemóvel do objeto Contato.
     *
     * @return
     */
    public String getNum() {
        return numStr;
    }


    /**
     *  Método toString para imprimir detalhes do objeto Contato.
     *
     * @return
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(birthDate);
        return "Nome: " + name + " | Data de Nascimento: " + date + " | Telemóvel: " + numStr;
    }

}
