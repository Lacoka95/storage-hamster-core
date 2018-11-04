package hu.storagehamster.www.service;

import hu.storagehamster.www.entity.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class OutFlowHandlerTest {

	@Mock
	private PalletService palletService;

	@InjectMocks
	private OutFlowHandler outFlowHandler;

	private static final Outflow OUTFLOW_1 = new Outflow(1,20);
	private static final Outflow OUTFLOW_2 = new Outflow(2,40);
	private static final Outflow OUTFLOW_3 = new Outflow(3,60);
	private static final OutflowWrapper OUTFLOW_WRAPPER= new OutflowWrapper(Arrays.asList(OUTFLOW_1,OUTFLOW_2,OUTFLOW_3));
	private static final Page<Pallet> PALLET_PAGE =new PageImpl<>(Collections.emptyList());

	@Before
	public void init(){
		givenAPalletService();
	}

	@Test
	public void testThatEachOutflowMakesADeleteCall(){
		whenCallingHandler();
		thenDeletePalletsWasCalledNTimes(OUTFLOW_WRAPPER.getOutflows().size());
	}

	private void givenAPalletService() {
		Mockito.when
						(palletService.findByproduct_id(anyLong(),any(PageRequest.class)))
						.thenReturn(PALLET_PAGE);
	}
	private void whenCallingHandler(){
		outFlowHandler.handleOutflow(OUTFLOW_WRAPPER);

	}
	private void thenDeletePalletsWasCalledNTimes(int count){
		Mockito.verify(palletService, Mockito.times(count)).deletePallets(any());

	}

}