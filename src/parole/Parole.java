/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parole;

/**
 *
 * @author Administrator
 */
public class Parole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestioneIO io = new GestioneIO();
//        String [] s=new String[]{"123","456","789"};
//        System.out.println(s);
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
        int option;
        do {
            option = io.getInt();
        } while (option > 4 || option < 0);

        switch (option) {
            case 1:
                versioneHashSet(io);
                break;
            case 2:
                versioneHashMap(io);
                break;
            case 3:
                versioneArrayList(io);
                break;
            case 4:
                System.exit(0);
        }
//        versioneArrayList(io);
//        versioneHashMap(io);
//        versioneHashSet(io);
    }

    public static void versioneArrayList(GestioneIO io) {
        System.out.println("Numero di parole diverse tra loro: " + io.readFromFileArrayList());
    }

    public static void versioneHashMap(GestioneIO io) {
        System.out.println("Numero di parole diverse tra loro: " + io.readFromFileHashMap());
    }

    public static void versioneHashSet(GestioneIO io) {
        System.out.println("Numero di parole diverse tra loro: " + io.readFromFileHashSet());
    }

}
