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
     * @return
     */
    public Contato getPrev() {
        return prev;
    }

    /**
     * @param prev
     */
    public void setPrev(Contato prev) {
        this.prev = prev;
    }

    /**
     * @return
     */
    public Contato getNext() {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(Contato next) {
        this.next = next;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return
     */
    public String getNum() {
        return numStr;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(birthDate);
        return "Nome: " + name + " | Data de Nascimento: " + date + " | Telemóvel: " + numStr;
    }

}
