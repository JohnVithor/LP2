/**
 * Em seguida, escreva casos de teste JUnit para sua classe polinômio. Crie pelo
 * menos um teste positivo e um teste negativo para cada um dos métodos
 * solicitados.
 */
package polinomiosTesters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import polinomios.OverFlowException;
import polinomios.Termo;

/**
 * Classe de teste para a Classe Termo.
 * 
 * @author JohnVithor
 */
class TermoTest {
    Random gerador = new Random();

    /**
     * Test method for {@link polinomios.Termo#Termo(double, int)}.
     */
    @Test
    final void testTermoConstructor() {
        {
            Termo termo = new Termo(0, 0);
            assertEquals(0, termo.getCoeficient());
            assertEquals(0, termo.getExponent());
        }
        {
            Termo termo = new Termo(Integer.MAX_VALUE, Integer.MAX_VALUE);
            assertEquals(Integer.MAX_VALUE, termo.getCoeficient());
            assertEquals(Integer.MAX_VALUE, termo.getExponent());
        }
        {
            Termo termo = new Termo(Integer.MIN_VALUE, Integer.MIN_VALUE);
            assertEquals(Integer.MIN_VALUE, termo.getCoeficient());
            assertEquals(Integer.MIN_VALUE, termo.getExponent());
        }
        {
            int coeficiente = gerador.nextInt();
            int expoente = gerador.nextInt();
            Termo termo = new Termo(coeficiente, expoente);
            assertEquals(coeficiente, termo.getCoeficient());
            assertEquals(expoente, termo.getExponent());
        }
    }

    /**
     * Test method for {@link polinomios.Termo#insere(polinomios.Termo)}.
     */
    @Test
    final void testInsere() {
        {
            Termo termo = new Termo(Integer.MAX_VALUE, Integer.MAX_VALUE);
            Termo newTermo = new Termo(Integer.MIN_VALUE, Integer.MIN_VALUE);
            termo.insere(newTermo);
            assertEquals(Integer.MIN_VALUE, termo.getCoeficient());
            assertEquals(Integer.MIN_VALUE, termo.getExponent());
        }
        {
            Termo termo = new Termo(Integer.MIN_VALUE, Integer.MIN_VALUE);
            Termo newTermo = new Termo(Integer.MAX_VALUE, Integer.MAX_VALUE);
            termo.insere(newTermo);
            assertEquals(Integer.MAX_VALUE, termo.getCoeficient());
            assertEquals(Integer.MAX_VALUE, termo.getExponent());
        }
        {
            int coeficiente = gerador.nextInt();
            int expoente = gerador.nextInt();
            Termo termo = new Termo(0, 0);
            Termo newTermo = new Termo(coeficiente, expoente);
            termo.insere(newTermo);
            assertEquals(coeficiente, termo.getCoeficient());
            assertEquals(expoente, termo.getExponent());
        }
    }

    /**
     * Test method for {@link polinomios.Termo#some(double)}.
     */
    @Test
    final void testSome() {
        {
            Termo termo = new Termo(Integer.MAX_VALUE, 0);
            try {
                termo.some(0);
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(Integer.MAX_VALUE, termo.getCoeficient(), "" + termo.getCoeficient());
        }
        {
            Termo termo = new Termo(0, 0);
            try {
                termo.some(Integer.MAX_VALUE);
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(Integer.MAX_VALUE, termo.getCoeficient(), "" + termo.getCoeficient());
        }
        {
            Termo termo = new Termo(0, 0);
            try {
                termo.some(Integer.MIN_VALUE);
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(Integer.MIN_VALUE, termo.getCoeficient(), "" + termo.getCoeficient());
        }
        {
            Termo termo = new Termo(Integer.MAX_VALUE, 0);
            try {
                termo.some(1);
                System.out.println(termo.getCoeficient());
                System.out.println(Integer.MIN_VALUE);
                fail("Era esperado que uma OverFlowException fosse lançada");
            } catch (OverFlowException ofe) {
                assertEquals("Adicionar 1 a " + Integer.MAX_VALUE
                                + " gera um overflow / underflow.", ofe.getMessage());
            }
        }
        {
            Termo termo = new Termo(Integer.MIN_VALUE, 0);
            try {
                termo.some(-1);

                fail("Era esperado que uma OverFlowException fosse lançada");
            } catch (OverFlowException ofe) {
                assertEquals("Subtrair 1 de " + Integer.MIN_VALUE
                                + " gera um overflow / underflow.", ofe.getMessage());
            }
        }
    }

    /**
     * Test method for {@link polinomios.Termo#calcula(double)}.
     */
    @Test
    final void testCalcula() {
        {
            Termo termo = new Termo(0, 0);
            try {
                assertEquals(0, termo.calcula(gerador.nextInt()));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }
        }
        {
            int coeficiente = gerador.nextInt();
            Termo termo = new Termo(coeficiente, 0);
            try {
                assertEquals(coeficiente, termo.calcula(gerador.nextInt()));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }
        }
        {
            int x = gerador.nextInt();
            Termo termo = new Termo(1, 1);
            try {
                assertEquals(x, termo.calcula(x));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }
        }
        {
            int coeficiente = gerador.nextInt();
            int expoente = Integer.MAX_VALUE;
            Termo termo = new Termo(coeficiente, expoente);
            try {
                assertEquals(0, termo.calcula(0));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }
        }
        {
            int coeficiente = Integer.MAX_VALUE;
            int expoente = Integer.MAX_VALUE;
            Termo termo = new Termo(coeficiente, expoente);
            try {
                termo.calcula(2);
                fail("Era esperado que uma OverFlowException fosse lançada");
            } catch (OverFlowException ofe) {
                assertEquals("Elevar 2 a 2147483647 gera um overflow / underflow.",
                                ofe.getMessage());
            }
        }
        {
            int coeficiente = Integer.MAX_VALUE;
            int expoente = 2;
            Termo termo = new Termo(coeficiente, expoente);
            try {
                termo.calcula(2);
                fail("Era esperado que uma OverFlowException fosse lançada");
            } catch (OverFlowException ofe) {
                assertEquals("Multiplicar 2147483647 por 4.0 gera um overflow / underflow.",
                                ofe.getMessage());
            }
        }
    }
}
