package com.github.borisosipov.proxysample.tests;

import com.browserup.bup.client.ClientUtil;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SampleTest {
    @BeforeEach
    void foo() {
        Configuration.proxyEnabled = true;
        Configuration.proxyHost = ClientUtil.getConnectableAddress().getHostAddress();
    }

    @Test
    void bar() {
        Selenide.open("http://www.columbia.edu/");
        Map<String, Object> stringObjectMap = WebDriverRunner.getSelenideProxy().getSeleniumProxy().toJson();
        List<String> noProxy = (List<String>) stringObjectMap.get("noProxy");
        assert Objects.equals(noProxy.get(0), "github.com");
    }
}
