package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById(){

        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri);

    }

    @Test
    void testeUpdateBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testeDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById(){

        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder().customerName("Joe").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri);

    }

    @Test
    void testeUpdateCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder().customerName("Jim").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testeDeleteCustomer(){

        client.deleteCustomer(UUID.randomUUID());
    }
}
