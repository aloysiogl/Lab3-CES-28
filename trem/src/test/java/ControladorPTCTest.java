import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

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
    public void testCrossingAndSensor() {
        when(sensor.isCruzamento()).thenReturn(true);
        when(sensor.getVelocidade()).thenReturn(110.0);
        when(painelCondutor.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
    }

    @After
    public void run() {
        controlador.run();
    }

}