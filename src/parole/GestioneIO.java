/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parole;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class GestioneIO {

    int numeroParole, numeroParoleDiverse = 0;
    String[] parole = null;
    ArrayList al = new ArrayList();
    HashMap<String, Integer> map;
    HashSet set;

    public GestioneIO() {
        map = new HashMap<>();
        set = new HashSet();
    }

    public int getInt() {
        Scanner lettore = new Scanner(System.in);
        System.out.println("<opzione>:");
        System.out.println("1)HashSet");
        System.out.println("2)HashMap");
        System.out.println("3)ArrayList");
        System.out.println("4)Exit");
        System.out.print("Inserisci un numero...");
        return lettore.nextInt();
    }

    public int readFromFileHashSet() {
        try {
            FileInputStream fis = new FileInputStream("dati/romanzo.txt");//prova.txt---romanzo.txt---romanzi.txt
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                String str = br.readLine();
                System.out.println(str);
                parole = str.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < parole.length; i++) {
                    if (set.contains(parole[i])) {
                        numeroParoleDiverse++;
                    }
                    set.add(parole[i]);
                    numeroParole++;
                }
            }
            System.out.println("\n-------------------------");
            System.out.println(set.toString());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                System.out.print("Value:(" + it.next().toString() + ")\t");
            }
            System.out.println("\n-------------------------");
            System.out.println("Numero di parole: " + numeroParole);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return numeroParoleDiverse;

    }

    public int readFromFileHashMap() {
        try {
            FileInputStream fis = new FileInputStream("dati/romanzo.txt");//prova.txt---romanzo.txt---romanzi.txt
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                String str = br.readLine();
//                System.out.println(str);
                parole = str.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < parole.length; i++) {
                    if (map.containsKey(parole[i])) {
                        numeroParoleDiverse++;
                        map.replace(parole[i],map.get(parole[i]), map.get(parole[i])+1);
                    } else if (map.isEmpty() || !map.containsKey(parole[i])) {
                        map.put(parole[i], 1);
                    }
                    numeroParole++;
                }
            }
            System.out.println(map);
            System.out.println("Numero di parole: " + numeroParole);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return numeroParoleDiverse;
    }

    public int readFromFileArrayList() {
        try {
            FileInputStream fis = new FileInputStream("dati/romanzo.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
//            for (int i = 0; i < br.hashCode(); i++) {
//                System.out.println(br.readLine());
//            }
            while (br.ready()) {
                String str = br.readLine();
                System.out.println(str);
                parole = str.split(" |,|\\.|;|:|'|-|!|\\?");
//                System.out.println("Numero di parole separati: "+parole.length);
                for (int i = 0; i < parole.length; i++) {
//                    System.out.print(parole[i]+"\t");
                }
//                System.out.println("\n----------------------");

                for (int i = 0; i < parole.length; i++) {
                    al.add(parole[i]);
//                    if (m.containsKey(parole[i])) {
//                        conteggio++;
//                    }
//                    m.put(parole[i], parole[i]);
                }
//                System.out.println(m.toString());
//                System.out.println(d.toString());
//                System.out.println("Lunghezza di arrayList: "+d.getSize());
                for (int i = 0; i < al.size(); i++) {
//                    System.out.print(d.getDato(i)+"\t");
                }
            }
            System.out.println("Numero di parole: " + al.size());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return numeroParoleDiverse;
    }

}
