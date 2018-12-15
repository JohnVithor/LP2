/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professores;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johnvithor
 */
public class Professores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Professor> ListaProfessores = new ArrayList<>();
        ListaProfessores.add(new ProfessorHorista(40, "30", "joao", "123456", 20));
        ListaProfessores.get(0).printData();
    }
    
}
