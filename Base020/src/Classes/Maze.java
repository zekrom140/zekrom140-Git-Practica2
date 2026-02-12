package Classes;

import java.io.*;
import java.util.Scanner;

public class Maze {

    private char[][] map;
    private String filename;
    private boolean loaded;
    private String maze ="laberinto";
    private String txt = ".txt";

    private int startI, startJ,endI, endJ;
    private boolean startEndSet;

    private static final String MAZES_PATH = "assets/mazes/";

    private Scanner kb = new Scanner(System.in);

    // Constructor
    public Maze() {
        loaded = false;
        startEndSet = false;
    }

    public void clear() {
        map = null;
        filename = null;
        loaded = false;
        startEndSet = false;
    }
    public void loadMaze() {

        System.out.println("\n--- CARGAR LABERINTO ---");

        while (true) {

            System.out.print("Introduce el número del laberinto (1-4): ");
           
            String num = kb.nextLine();
            if(num.length()>=2) {
            	System.out.print("No debes introducir nada mas que el numero de laberinto");
            }
            String fullName = maze + num + txt;
            File f = new File(MAZES_PATH + fullName);
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                
                String line;
                int rows = 0;
                int cols = 0;

                while ((line = br.readLine()) != null) {
                    rows++;
                    cols = line.length();
                }
                br.close();

                map = new char[rows][cols];
               
                br = new BufferedReader(new FileReader(f));

                int i = 0;
                while ((line = br.readLine()) != null) {
                    for (int j = 0; j < cols; j++) {
                        map[i][j] = line.charAt(j);
                    }
                    i++;
                }
                br.close();

                loaded = true;
                filename = fullName;
                startEndSet = false;

                System.out.println("Laberinto cargado correctamente: " + filename);
                return;

            } catch (IOException e) {
                System.out.println(" Error leyendo el fichero.");
            }
        }
    }



    public void showMaze() {

        if (!loaded) {
            System.out.println("Primero debes cargar un laberinto.");
            return;
        }

        System.out.println("\n--- LABERINTO ACTUAL ---");
        System.out.println("Archivo: " + filename);

        
        System.out.print("   ");
        for (int j = 0; j < map[0].length; j++) {
            System.out.print(j % 10); // % 10 para no descuadrar
        }
        System.out.println();

        for (int i = 0; i < map.length; i++) {


            System.out.printf("%2d ", i);// le doy el formato %2d para no descuadrar cuando sea de 2 cifras (lo he tenido que mirar en chat gpt)

            for (int j = 0; j < map[i].length; j++) {

             
                if (startEndSet && i == startI && j == startJ) {
                    System.out.print("I");
                } else if (startEndSet && i == endI && j == endJ) {
                    System.out.print("F");
                } else {
                    System.out.print(map[i][j]);
                }
            }

            System.out.println();
        }
    }

    public void setStartEnd() {

        if (!loaded) {
            System.out.println("Primero debes cargar un laberinto.");
            return;
        }

        System.out.println("\n--- ESTABLECER INICIO Y FIN ---");

        int maxFilas = map.length;
        int maxColumnas = map[0].length;

        try {

           
            System.out.print("Coordenada I de inicio (0 - " + (maxFilas - 1) + "): ");
            startI = Integer.parseInt(kb.nextLine());

            System.out.print("Coordenada J de inicio (0 - " + (maxColumnas - 1) + "): ");
            startJ = Integer.parseInt(kb.nextLine());

            if (startI < 0 || startI >= maxFilas || startJ < 0 || startJ >= maxColumnas) {
                System.out.println("Error: Coordenadas de inicio fuera del laberinto.");
                return;
            }
            
            System.out.print("Coordenada I de fin (0 - " + (maxFilas - 1) + "): ");
            endI = Integer.parseInt(kb.nextLine());

            System.out.print("Coordenada J de fin (0 - " + (maxColumnas - 1) + "): ");
            endJ = Integer.parseInt(kb.nextLine());

            if (endI < 0 || endI >= maxFilas || endJ < 0 || endJ >= maxColumnas) {
                System.out.println("Error: Coordenadas de fin fuera del laberinto.");
                return;
            }

          
            startEndSet = true;

            System.out.println("Casillas establecidas correctamente.");

        } catch (Exception e) {
            System.out.println("Error: introduce números válidos.");
        }
    }

}

