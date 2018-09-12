import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPTCTest {

    @Mock
    private Sensor sensor;

    @Mock
    private Datacenter datacenter;

    @Mock
    private PainelCondutor painelCondutor;

    @Test
    public void testInitialization(){
        ControladorPTC controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
    }

}