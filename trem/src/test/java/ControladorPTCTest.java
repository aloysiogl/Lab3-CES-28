import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPTCTest {
    private ControladorPTC controlador;

    @Mock
    private Sensor sensor;

    @Mock
    private Datacenter datacenter;

    @Mock
    private PainelCondutor painelCondutor;

    @Before
    public void setUp() {
        controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
    }

    @Test
    public void testInitialization(){
//        controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
    }

    @Test
    public void testNotCruzamento(){
        Double velocidade = 100.00;

        //Fazendo o is cruzamento retornar false
        when(sensor.isCruzamento()).thenReturn(false);
        when(sensor.getVelocidade()).thenReturn(velocidade);

        String velocidadeString = velocidade.toString();
        controlador.run();
        verify(sensor, times(34)).getVelocidade();
    }

    @Test
    public void testCrossingAndSensor() {
        when(sensor.isCruzamento()).thenReturn(true);
        when(sensor.getVelocidade()).thenReturn(110.0);
        when(painelCondutor.imprimirAviso("Velocidade alta", 1)).thenReturn(false);
        controlador.run();
        verify(sensor, times(1)).isCruzamento();
        verify(sensor, times(1)).getVelocidade();
        verify(painelCondutor, times(2)).imprimirAviso("Velocidade alta", 1);
        verify(painelCondutor, times(1)).diminuiVelocidadeTrem(20);
    }

    @After
    public void run() {

    }

}