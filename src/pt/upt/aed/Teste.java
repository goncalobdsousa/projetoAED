package pt.upt.aed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teste {
    private static Lista [] array;

    /**
     * Mét
     *
     * @param args //
     */
    public static void main(String[] args) {
        array = new Lista[999];
        menu();
    }

    /**
     * Método que mostra o menu e executa
     *
     */
    @SuppressWarnings("resource")
    public static void menu() {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        System.out.println("1. Registar Cliente");
        System.out.println("2. Ver dados de um Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("0. Sair");

        int escolha = inputInt.nextInt();

        if(escolha != 0) {
            switch (escolha) {
                case 1: {
                    System.out.print("Insira o nome do cliente: ");
                    String name = inputStr.nextLine();

                    System.out.print("Insira a data de nascimento (dd/mm/aaaa): ");
                    String birthDate = inputStr.nextLine();
                    SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy");
                    Date newDate = null;

                    while(!isDate(birthDate)) {
                        System.out.println("Data invalida!");
                        System.out.print("Insira a data de nascimento (dd/mm/aaaa): ");
                        birthDate = inputStr.nextLine();
                    }
                    try {
                        newDate = dateInput.parse(birthDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    System.out.print("Insira o número de telemóvel: ");
                    String numStr = inputStr.next();

                    while(!isNumeric(numStr)) {
                        System.out.println("Erro (Não é um número)!");
                        System.out.print("Insira o número de telemóvel: ");
                        numStr = inputStr.next();
                    }

                    int hashCode = toHash(numStr);
                    if(array[hashCode] == null) {
                        array[hashCode] = new Lista();
                    }
                    array[hashCode].insert(name, newDate, numStr);
                    break;
                }
                case 2:{
                    System.out.print("Insira o número de telemóvel do cliente a procurar: ");
                    String numStr = inputStr.next();

                    while(!isNumeric(numStr)) {
                        System.out.println("Erro (Não é um número)!");
                        System.out.print("Insira o número de telemóvel do cliente a procurar: ");
                        numStr = inputStr.next();
                    }

                    int hashCode = toHash(numStr);
                    if(array[hashCode] != null) {
                        Contato temp = array[hashCode].search(numStr);
                        if(temp != null) {
                            System.out.println(temp);
                        }else {
                            System.out.println("Número não existe");
                        }

                    } else {
                        System.out.println("Número não existe");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Insira o número de telemóvel do cliente a remover: ");
                    String numStr = inputStr.next();

                    while(!isNumeric(numStr)) {
                        System.out.println("Erro (Não é um número)!");
                        System.out.print("Insira o número de telemóvel: ");
                        numStr = inputStr.next();
                    }

                    int hashCode = toHash(numStr);
                    if(array[hashCode] != null) {
                        System.out.println(array[hashCode].remove(numStr));
                    } else {
                        System.out.println("Número não existe");
                    }
                    break;
                }
                default:
                    System.out.println("A opção escolhida não existe");
            }
            menu();
        }
    }

    /**
     * @param numStr
     * @return
     */
    private static int toHash(String numStr) {
        return Integer.parseInt(numStr.substring(numStr.length()-3));
    }

    /**
     * @param birthDate
     * @return
     */
    private static boolean isDate(String birthDate) {
        SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            dateInput.parse(birthDate);
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }

    }

    /**
     * @param str
     * @return
     */
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }

}
