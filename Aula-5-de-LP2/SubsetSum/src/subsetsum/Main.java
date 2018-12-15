/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsetsum;

import java.util.ArrayList;

/**
 *
 * @author johnvithor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        ArrayList<Integer> vetor = new ArrayList<>();
        vetor.add(4);
        vetor.add(2);
        vetor.add(3);
        vetor.add(5);
        vetor.add(1);
        vetor.add(0);
        SubsetSum test = new SubsetSum(vetor);
        Integer target = 15;
        ArrayList<Integer> result = test.subsetSum(target);
        System.out.println("No array: " + vetor);
        System.out.println("O subarray que soma '" + target
                + "' é o subarray formado pelas posições:");
        System.out.println(result);
        System.out.println("Sendo portanto os valores: ");
        System.out.print("[");
        for (int i = 0; i < result.size() - 1; ++i) {
            System.out.print(vetor.get(result.get(i)) + ", ");
        }
        System.out.println(vetor.get(result.size() - 1) + "]");
    }
}
