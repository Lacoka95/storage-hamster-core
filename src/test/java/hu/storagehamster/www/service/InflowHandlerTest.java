package hu.storagehamster.www.service;

import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import hu.storagehamster.www.entity.Inflow;
import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.entity.Shelf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class InflowHandlerTest {

	@Mock
	private ProductService productService;
	@Mock
	private ShelfService shelfService;
	@Mock
	private PalletService palletService;
	@InjectMocks
	private InflowHandler inflowHandler;

	private static final Product PRODUCT = new Product("Coca", "Cola", 20);;
	private static final Shelf SHELF = new Shelf("R7", 10, new ArrayList<>());
	private static final Inflow INPUT_INFLOW = new Inflow("R7", 1, 10, 5);

	@Before
	public void init()
	{
		givenAProductService();
		givenAShelfService();
	}

	@Test(expected = ShelfOutOfCapacityException.class)
	public void whenShelfIsFullExceptionIsThrown()
	{
		givenAShelfServiceWithException();

		whenCallingHandler();

		thenExceptionIsThrown();
	}

	@Test
	public void testThatCorrectNumberOfPalletsAreSaved()
	{
		whenCallingHandler();

		thenShelfServiceSaveIsCalledNTimes(INPUT_INFLOW.getNumberOfPallets());
	}

	private void givenAProductService() {
		Mockito.when(productService.findById(INPUT_INFLOW.getProductId())).thenReturn(PRODUCT);
	}

	private void givenAShelfService(){
		Mockito.when(shelfService.findByLoco(INPUT_INFLOW.getShelfId())).thenReturn(SHELF);
	}

	private void givenAShelfServiceWithException(){
		Mockito.doThrow(ShelfOutOfCapacityException.class)
						.when(shelfService).storePallet(any(), any());
	}

	private void whenCallingHandler()
	{
		inflowHandler.handleInflow(INPUT_INFLOW);
	}

	private void thenExceptionIsThrown()
	{
		//empty
	}

	private void thenShelfServiceSaveIsCalledNTimes(int count)
	{
		Mockito.verify(shelfService, Mockito.times(count)).save(any());
	}
}