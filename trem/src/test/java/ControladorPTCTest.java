import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPTCTest {

    @Mock
    private Sensor repository;

    @Mock
    private Datacenter datacenter;

    @Mock
    private PainelCondutor painelCondutor;

    @Test
    public void test(){
        ControladorPTC(sensor, datacenter, painelCondutor);
    }

}