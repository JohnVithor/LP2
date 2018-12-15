/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsetsum;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author johnvithor
 */
public class SubsetSum {

    /**
     * vetor com os inteiros.
     */
    private final ArrayList<Integer> origin;

    /**
     * Construtor.
     *
     * @param paramOrigin Lista de inteiros.
     */
    public SubsetSum(final ArrayList<Integer> paramOrigin) {
        this.origin = paramOrigin;
    }

    /**
     * Busca o subvetor cuja soma é igual ao numero informado.
     *
     * @param target numero buscado.
     * @return subvetor que contem o resultado em posições.
     */
    public final ArrayList<Integer> subsetSum(final Integer target) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < origin.size(); ++i) {
            for (int j = i; j < origin.size(); j++) {
                sum += origin.get(j);
                result.add(j);
                if (Objects.equals(sum, target)) {
                    return result;
                } else if (sum > target) {
                    result.clear();
                    sum = 0;
                    break;
                }
            }
        }
        return result;
    }
}
