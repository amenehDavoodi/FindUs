package com.example.testapplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

//        int value=System.in.read();
//
//        PGraph pg = new PGraph();
//        pg.Prim(new int[][]{new int[1]}, 6);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);
    }
}

class PGraph {

    public void Prim(int G[][], int V) {

        int INF = 9999999;

        int no_edge;
        boolean[] selected = new boolean[V];

        Arrays.fill(selected, false);

        no_edge = 0;


        selected[0] = true;

        // print for edge and weight
        System.out.println("Edge : Weight");

        while (no_edge < V - 1) {

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) { // not in selected and there is an edge if (!selected[j] && G[i][j] != 0) { if (min > G[i][j]) {
                        min = G[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
        }
    }


}



