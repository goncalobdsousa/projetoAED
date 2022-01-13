package pt.upt.aed;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contato {
    private String name;
    private Date birthDate;
    private String numStr;
    private Contato next;
    private Contato prev;


    public Contato(String name, Date birthDate, String numStr) {
        this.name = name;
        this.birthDate = birthDate;
        this.numStr = numStr;
    }


    public Contato getPrev() {
        return prev;
    }

    public void setPrev(Contato prev) {
        this.prev = prev;
    }

    public Contato getNext() {
        return next;
    }

    public void setNext(Contato next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNum() {
        return numStr;
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(birthDate);
        return "Nome: " + name + " | Data de Nascimento: " + date + " | Telemóvel: " + numStr;
    }

}
