import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

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

    }

    @Test
    public void testHighSpeedCrossing() {
        when(sensor.isCruzamento()).thenReturn(true);
        when(sensor.getVelocidade()).thenReturn(110.0);
        when(painelCondutor.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
        controlador.run();
        verify(sensor, times(1)).isCruzamento();
        verify(sensor, times(1)).getVelocidade();
        verify(painelCondutor, times(1)).imprimirAviso("Velocidade alta", 1);
        verify(painelCondutor, times(0)).diminuiVelocidadeTrem(20);
    }

    @Test
    public void testLowSpeedCrossing() {
        when(sensor.isCruzamento()).thenReturn(true);
        when(sensor.getVelocidade()).thenReturn(15.0);
        when(painelCondutor.imprimirAviso("Velocidade alta", 1)).thenReturn(false);
        controlador.run();
        verify(sensor, times(1)).isCruzamento();
        verify(sensor, times(1)).getVelocidade();
        verify(painelCondutor, times(2)).imprimirAviso("Velocidade Baixa", 1);
        verify(painelCondutor, times(1)).aceleraVelocidadeTrem(20);
    }

}