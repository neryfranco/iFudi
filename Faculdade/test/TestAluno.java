/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import model.Aluno;
import model.AlunoEstadoEvadido;
import model.AlunoEstadoExpulso;
import model.AlunoEstadoFormado;
import model.AlunoEstadoJubilado;
import model.AlunoEstadoMatriculado;
import model.AlunoEstadoTrancado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nery
 */
public class TestAluno extends TestCase{
    
    Aluno aluno;
    
    public TestAluno() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        aluno = new Aluno();
    }
    
    @After
    public void tearDown() {
    }
    
    public void testAlunoMatriculadoMatricular() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Aluno Matriculado não pode matricular", aluno.matricular());
    }
    
    public void testAlunoMatriculadoTrancar() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Pode trancar", aluno.trancar());
    }
    
    public void testAlunoMatriculadoTrancarEstado() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        aluno.trancar();
        assertEquals(new AlunoEstadoTrancado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoMatriculadoFormar() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Pode formar", aluno.formar());
    }
    
    public void testAlunoMatriculadoFormarEstado() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        aluno.formar();
        assertEquals(new AlunoEstadoFormado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoMatriculadoExpulsar() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoMatriculadoExpulsarEstado() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        aluno.expulsar();
        assertEquals(new AlunoEstadoExpulso().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoMatriculadoJubilar() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoMatriculadoJubilarEstado() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        aluno.jubilar();
        assertEquals(new AlunoEstadoJubilado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoMatriculadoEvadir() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        assertEquals("Pode evadir", aluno.evadir());
    }
    
    public void testAlunoMatriculadoEvadirEstado() {
        aluno.setEstado(new AlunoEstadoMatriculado());
        aluno.evadir();
        assertEquals(new AlunoEstadoEvadido().getClass(), aluno.getEstado().getClass());
    }
    
    /*--------------------------------------*/
    
    public void testAlunoTrancadoTrancar() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Aluno Trancado não pode trancar", aluno.trancar());
    }
    
    public void testAlunoTrancadoMatricular() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Pode matricular", aluno.matricular());
    }
    
    public void testAlunoTrancadoMatricularEstado() {
        aluno.setEstado(new AlunoEstadoTrancado());
        aluno.matricular();
        assertEquals(new AlunoEstadoMatriculado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoTrancadoFormar() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Aluno Trancado não pode formar", aluno.formar());
    }
    
    public void testAlunoTrancadoExpulsar() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Aluno Trancado não pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoTrancadoJubilar() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoTrancadoJubilarEstado() {
        aluno.setEstado(new AlunoEstadoTrancado());
        aluno.jubilar();
        assertEquals(new AlunoEstadoJubilado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoTrancadoEvadir() {
        aluno.setEstado(new AlunoEstadoTrancado());
        assertEquals("Pode evadir", aluno.evadir());
    }
    
    public void testAlunoTrancadoEvadirEstado() {
        aluno.setEstado(new AlunoEstadoTrancado());
        aluno.evadir();
        assertEquals(new AlunoEstadoEvadido().getClass(), aluno.getEstado().getClass());
    }
    
    /*--------------------------------------*/
    
    public void testAlunoFormadoMatricular() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode matricular", aluno.matricular());
    }
    
    public void testAlunoFormadoTrancar() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode trancar", aluno.trancar());
    }
    
    public void testAlunoFormadoFormado() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode formar", aluno.formar());
    }
    
    public void testAlunoFormadoExpulsar() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoFormadoJubilar() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoFormadoEvadir() {
        aluno.setEstado(new AlunoEstadoFormado());
        assertEquals("Aluno Formado não pode evadir", aluno.evadir());
    }
    
    /*--------------------------------------*/
    
    public void testAlunoExpulsoMatricular() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode matricular", aluno.matricular());
    }
    
    public void testAlunoExpulsoTrancar() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode trancar", aluno.trancar());
    }
    
    public void testAlunoExpulsoFormar() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode formar", aluno.formar());
    }
    
    public void testAlunoExpulsoExpulsar() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoExpulsoJubilar() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoExpulsoEvadir() {
        aluno.setEstado(new AlunoEstadoExpulso());
        assertEquals("Aluno Expulso não pode evadir", aluno.evadir());
    }
    
    /*--------------------------------------*/
    
    public void testAlunoJubiladoMatricular() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode matricular", aluno.matricular());
    }
    
    public void testAlunoJubiladoTrancar() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode trancar", aluno.trancar());
    }
    
    public void testAlunoJubiladoFormar() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode formar", aluno.formar());
    }
    
    public void testAlunoJubiladoExpulsar() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoJubiladoJubilar() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoJubiladoEvadir() {
        aluno.setEstado(new AlunoEstadoJubilado());
        assertEquals("Aluno Jubilado não pode evadir", aluno.evadir());
    }
    
    /*--------------------------------------*/
    
    public void testAlunoEvadidoMatricular() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Pode matricular", aluno.matricular());
    }
    
    public void testAlunoEvadidoMatricularEstado() {
        aluno.setEstado(new AlunoEstadoEvadido());
        aluno.matricular();
        assertEquals(new AlunoEstadoMatriculado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoEvadidoTrancar() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Aluno Evadido não pode trancar", aluno.trancar());
    }
    
    public void testAlunoEvadidoFormar() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Aluno Evadido não pode formar", aluno.formar());
    }
    
    public void testAlunoEvadidoExpulsar() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Aluno Evadido não pode expulsar", aluno.expulsar());
    }
    
    public void testAlunoEvadidoJubilar() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Pode jubilar", aluno.jubilar());
    }
    
    public void testAlunoEvadidoJubilarEstado() {
        aluno.setEstado(new AlunoEstadoEvadido());
        aluno.jubilar();
        assertEquals(new AlunoEstadoJubilado().getClass(), aluno.getEstado().getClass());
    }
    
    public void testAlunoEvadidoEvadir() {
        aluno.setEstado(new AlunoEstadoEvadido());
        assertEquals("Aluno Evadido não pode evadir", aluno.evadir());
    }
}
