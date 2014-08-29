package com.dyn.api.dw.util;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SmtpValueValidatorTest {

    private static final List<String> validIpAddresses = Arrays.asList(new String[] {
            "1.1.1.1","255.255.255.255","192.168.1.1","10.10.1.1",
            "132.254.111.10","26.10.2.10", "127.0.0.1"});
    private static final List<String> invalidIpAddresses = Arrays.asList(new String[] {
            "1.1.1.","10.280.13.50","400.168.1.1","10.10.1",
            "132.abc.111.10","26", "127.0.0.-1"});

    private static SmtpValueValidator validator;


    @BeforeClass
    public static void initValidator() {
        validator = new SmtpValueValidator();
    }


    @Test
    public void testValidIPs() {
        for(String validIp : validIpAddresses) {
            Assert.assertEquals(true, validator.validate(validIp));
        }
    }

    @Test
    public void testInValidIPs() {
        for(String invalidIp : invalidIpAddresses) {
            Assert.assertEquals(false, validator.validate(invalidIp));
        }
    }
}
