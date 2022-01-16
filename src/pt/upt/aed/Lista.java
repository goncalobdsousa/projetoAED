package pt.upt.aed;

import java.util.Date;

public class Lista {
    private Contato first;
    private Contato last;

    /**
     * Construtor do Objeto Lista.
     */
    public Lista() {}

    /**
     * Cria e insere um novo objeto do tipo Contato numa lista ornedada de forma crescente com base na comparação dos números de telemovel da string dos objetos Contato
     * , o método verifica em que posição inserir, seja inicio, meio ou fim.
     *
     * @param name Nome do Contato.
     * @param birthDate Data de Nascimento do Contato.
     * @param numStr Número de Telemóvel formato String.
     */
    public void insert(String name, Date birthDate, String numStr) {
        Contato newContato = new Contato(name, birthDate, numStr);
        if(first == null) {
            first = newContato;
            last = newContato;
        }else if(numStr.compareTo(first.getNum()) < 0) {
            newContato.setNext(first);
            first.setPrev(newContato);
            first = newContato;
        }else if(numStr.compareTo(last.getNum()) > 0) {
            last.setNext(newContato);
            newContato.setPrev(last);
            last = newContato;
        }else {
            Contato temp = first;
            while(temp.getNext() != null && numStr.compareTo(temp.getNext().getNum()) > 0) {
                temp = temp.getNext();
            }
            newContato.setNext(temp.getNext());
            newContato.setPrev(temp);
            temp.getNext().setPrev(newContato);
            temp.setNext(newContato);
        }
    }

    /**
     * Pesquisa um objeto Contato com base no número de telemóvel.
     *
     * @param numStr Número de Telemóvel formato String.
     * @return Objeto Procurado.
     */
    public Contato search(String numStr) {
        if(first != null && first.getNum().compareTo(numStr)<=0 && last.getNum().compareTo(numStr)>=0) {
            if(first.getNum().equals(numStr)) {
                return first;
            } else if(last.getNum().equals(numStr)) {
                return last;
            } else {
                Contato temp = first;
                while(temp != null && !temp.getNum().equals(numStr) && temp.getNum().compareTo(numStr)<0) {
                    temp = temp.getNext();
                }
                if(temp!= null && temp.getNum().equals(numStr)){
                    return temp;
                }
                return null;
            }
        }
        return null;
    }

    /**
     * Remove e retorna um objeto Contato com base no número de telemóvel.
     *
     * @param numStr Número de Telemóvel formato String.
     * @return Objeto Contato Removido.
     */
    public Contato remove(String numStr) {
        Contato temp = search(numStr);
        if(temp != null) {
            if(temp == first) {
                first = first.getNext();
            } else if(temp == last) {
                last = last.getPrev();
            } else {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
            }
        }
        return temp;
    }
}
