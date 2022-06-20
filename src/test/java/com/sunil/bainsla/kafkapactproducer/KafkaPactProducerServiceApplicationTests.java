package com.sunil.bainsla.kafkapactproducer;

import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit5.MessageTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Consumer;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.UUID;

@SpringBootTest(classes = KafkaPactProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("paymentProviderKafka")
@Consumer("paymentConsumerKafka")
@PactBroker(host = "localhost", port = "9292")
public class KafkaPactProducerServiceApplicationTests {

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void testTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new MessageTestTarget(Arrays.asList(this.getClass().getPackage().getName())));
    }

    @PactVerifyProvider("A valid Payment created event")
    public String verifyPaymentInformationMessage() throws JsonProcessingException {
        Payment
                payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setPaymentDate("2022-06-13");
        payment.setData("test");
        payment.setAmount(21212);
        return new ObjectMapper().writeValueAsString(payment);
    }

}


