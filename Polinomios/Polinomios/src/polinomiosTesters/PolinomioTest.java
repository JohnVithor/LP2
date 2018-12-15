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
import polinomios.Polinomio;
import polinomios.Termo;

/**
 * @author JohnVithor
 */
class PolinomioTest {

    Random gerador = new Random();

    /**
     * Test method for {@link polinomios.Polinomio#Polinomio(polinomios.Termo)}.
     */
    @Test
    final void testPolinomio() {
        {
            try {
                @SuppressWarnings("unused")
                Polinomio polinomio = new Polinomio(null);
                fail("Era esperado que uma NullPointerException fosse lançada");
            } catch (NullPointerException npe) {
                assertEquals("Não é possível criar um polinômio a partir de um Termo null",
                                npe.getMessage());
            }
        }
        {
            Termo termo = new Termo(0, 0);
            Polinomio polinomio = new Polinomio(termo);
            assertEquals(termo, polinomio.getTermo(0));
        }
        {
            Termo termo = new Termo(gerador.nextInt(), gerador.nextInt());
            Polinomio polinomio = new Polinomio(termo);
            assertEquals(termo, polinomio.getTermo(0));
        }
    }

    /**
     * Test method for {@link polinomios.Polinomio#insere(polinomios.Termo)}.
     */
    @Test
    final void testInsere() {
        {
            Termo termo0 = new Termo(0, 0);
            Polinomio polinomio = new Polinomio(termo0);
            Termo termo1 = new Termo(1, 1);
            try {
                polinomio.insere(termo1);
            } catch (NullPointerException npe) {
                fail(npe.getMessage());

            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(termo1, polinomio.getTermo(1));
        }
        {
            Termo termo0 = new Termo(0, 0);
            Polinomio polinomio = new Polinomio(termo0);
            try {
                polinomio.insere(null);
                fail("Era esperado que uma NullPointerException fosse lançada");
            } catch (NullPointerException npe) {
                assertEquals("Não é possível inserir um Termo null", npe.getMessage());
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }

            Termo termo1 = new Termo(2, 2);
            try {
                polinomio.insere(termo1);
            } catch (NullPointerException npe) {
                fail(npe.getMessage());
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(termo1, polinomio.getTermo(1));
        }
        {
            Termo termo0 = new Termo(0, 0);
            Polinomio polinomio = new Polinomio(termo0);
            assertEquals(null, polinomio.getTermo(1 + gerador.nextInt(Integer.MAX_VALUE - 1)));
        }
    }

    /**
     * Test method for {@link polinomios.Polinomio#calcula(polinomios.Polinomio)}.
     */
    @Test
    final void testCalcula() {
        {
            Polinomio polinomio = new Polinomio(new Termo(0, 0));
            try {
                polinomio.calcula(null);
                fail("NullPointerException não deveria ser lançada.");
            } catch (NullPointerException npe) {
                assertEquals("O polinomio a ser somado não pode ser null", npe.getMessage());
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
        }
        {
            Termo termo0 = new Termo(0, 0);
            Polinomio polinomio1 = new Polinomio(termo0);
            Polinomio polinomio2 = new Polinomio(termo0);
            try {
                polinomio1.calcula(polinomio2);
            } catch (NullPointerException npe) {
                fail("NullPointerException não deveria ser lançada.");
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(0, polinomio1.getTermo(0).getCoeficient());
        }
        {
            Polinomio polinomio1 = new Polinomio(new Termo(0, 0));
            try {
                polinomio1.insere(new Termo(4, 1));
                polinomio1.insere(new Termo(3, 2));
                polinomio1.insere(new Termo(1, 3));
            } catch (NullPointerException | OverFlowException e) {
                fail(e.getMessage());
            }

            Polinomio polinomio2 = new Polinomio(new Termo(1, 0));
            try {
                polinomio2.insere(new Termo(1, 1));
                polinomio2.insere(new Termo(2, 2));
                polinomio2.insere(new Termo(1, 3));
            } catch (NullPointerException | OverFlowException e) {
                fail(e.getMessage());
            }

            try {
                polinomio1.calcula(polinomio2);
            } catch (NullPointerException npe) {
                fail("NullPointerException não deveria ser lançada.");
            } catch (OverFlowException ofe) {
                fail(ofe.getMessage());
            }
            assertEquals(1, polinomio1.getTermo(0).getCoeficient());
            assertEquals(5, polinomio1.getTermo(1).getCoeficient());
            assertEquals(5, polinomio1.getTermo(2).getCoeficient());
            assertEquals(2, polinomio1.getTermo(3).getCoeficient());
        }
    }

    /**
     * Test method for {@link polinomios.Polinomio#resultado(double)}.
     */
    @Test
    final void testResultado() {
        {
            Polinomio polinomio = new Polinomio(new Termo(0, 0));
            try {
                assertEquals(0, polinomio.resultado(0));
                assertEquals(0, polinomio.resultado(Integer.MAX_VALUE));
                assertEquals(0, polinomio.resultado(Integer.MIN_VALUE));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }

        }
        {
            Polinomio polinomio = new Polinomio(new Termo(0, 0));
            try {
                polinomio.insere(new Termo(10, 1));
                polinomio.insere(new Termo(5, 2));
                polinomio.insere(new Termo(1, 3));
            } catch (NullPointerException | OverFlowException e) {
                fail(e.getMessage());
            }
            try {
                assertEquals(0, polinomio.resultado(0));
                assertEquals(16, polinomio.resultado(1));
                assertEquals(0 + 20 + 20 + 8, polinomio.resultado(2));
            } catch (OverFlowException e) {
                fail(e.getMessage());
            }
        }
        {
            Polinomio polinomio = new Polinomio(new Termo(Integer.MAX_VALUE, 2));
            try {
                polinomio.resultado(2);
                System.out.println(polinomio.resultado(2));
                System.out.println(Integer.MAX_VALUE);
                fail("Era esperado que uma OverFlowException fosse lançada");
            } catch (OverFlowException ofe) {
                assertEquals("Multiplicar 2147483647 por 4.0 gera um overflow / underflow.",
                                ofe.getMessage());
            }
        }
    }
}
