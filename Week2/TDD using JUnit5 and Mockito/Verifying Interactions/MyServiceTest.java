package org.example;

// For mock(), when()
import org.testng.annotations.Test;          // Import @Test annotation
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;
public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject the mock into your service
        MyService service = new MyService(mockApi);

        // Step 4: Call the method and assert the result
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}