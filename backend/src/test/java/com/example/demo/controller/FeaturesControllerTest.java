package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.CustomerService;
import com.example.demo.service.FeatureToggleService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class FeaturesControllerTest {

    @Autowired
    private FeaturesController controller;

    @MockBean
    private FeatureToggleService featureToggleService;

    @MockBean
    private CustomerService customerService;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(featureToggleService).isNotNull();
        assertThat(customerService).isNotNull();
    }

    @Test
    public void testFeatureResponseToBeEmpty() throws Exception {

        Mockito.when(
                customerService.getCustomerById("1234")
        ).thenReturn(
                Optional.empty()
        );

        Mockito.when(
                featureToggleService.getByTechnicalName("some name")
        ).thenReturn(
                Optional.empty()
        );

        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setName("some name");

        FeatureRequest featureRequest = new FeatureRequest();
        featureRequest.setCustomerId("1234");
        ArrayList<FeatureDTO> featureDTOs = new ArrayList<>();
        featureDTOs.add(featureDTO);
        featureRequest.setFeatures(featureDTOs);

        FeatureResponse featureResponse = controller.featureRequest(featureRequest);

        assertThat(featureResponse.getFeatures()).isEmpty();
    }

    @Test
    public void testFeatureRequestToContainGivenFeature() throws Exception {
        Customer customer = new Customer("1234");
        FeatureToggle featureToggle = new FeatureToggle();
        featureToggle.setTechnicalName("some name");

        Mockito.when(
                customerService.getCustomerById("1234")
        ).thenReturn(
                Optional.of(customer)
        );

        Mockito.when(
                featureToggleService.getByTechnicalName("some name")
        ).thenReturn(
                Optional.of(featureToggle)
        );

        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setName("some name");

        FeatureRequest featureRequest = new FeatureRequest();
        featureRequest.setCustomerId("1234");
        ArrayList<FeatureDTO> featureDTOs = new ArrayList<>();
        featureDTOs.add(featureDTO);
        featureRequest.setFeatures(featureDTOs);

        FeatureResponse featureResponse = controller.featureRequest(featureRequest);

        Mockito.verify(featureToggleService,
                Mockito.times(1))
                .getByTechnicalName("some name");

        Mockito.verify(featureToggleService,
                Mockito.times(1))
                .save(featureToggle);

        Mockito.verify(customerService,
                Mockito.times(1))
                .getCustomerById("1234");

        assertThat(featureResponse.getFeatures()).isNotEmpty();

        MatcherAssert.assertThat(
                featureResponse.getFeatures(),
                contains(hasProperty("name", is("some name")))
        );
    }

    @Test
    public void testFeaturesByCustomerToBeEmpty() {
        Mockito.when(
                customerService.getCustomerById("1234")
        ).thenReturn(
                Optional.empty()
        );

        FeatureResponse featureResponse = controller.featuresByCustomer("1234");

        assertThat(featureResponse).isNotNull();
        assertThat(featureResponse.getFeatures()).isEmpty();
    }

   @Test
   public void testFeaturesByCustomerToContainGivenFature() {
       Customer customer = new Customer();
       FeatureToggle featureToggle = new FeatureToggle();
       featureToggle.setTechnicalName("some name");
       customer.getFeatures().add(featureToggle);

       Mockito.when(
               customerService.getCustomerById("1234")
        ).thenReturn(
               Optional.of(customer)
        );

       FeatureResponse featureResponse = controller.featuresByCustomer("1234");

       Mockito.verify(customerService,
               Mockito.times(1))
               .getCustomerById("1234");

       assertThat(featureResponse.getFeatures()).isNotEmpty();

       MatcherAssert.assertThat(
               featureResponse.getFeatures(),
               contains(hasProperty("name", is("some name")))
       );
   }
}
