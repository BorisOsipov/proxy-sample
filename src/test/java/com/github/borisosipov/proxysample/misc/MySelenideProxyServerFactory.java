package com.github.borisosipov.proxysample.misc;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import com.codeborne.selenide.proxy.SelenideProxyServerFactory;
import org.openqa.selenium.Proxy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MySelenideProxyServerFactory implements SelenideProxyServerFactory {
    @Nonnull
    @Override
    public SelenideProxyServer create(Config config, @Nullable Proxy proxy) {
        SelenideProxyServer selenideProxyServer = new SelenideProxyServer(config, proxy);
        selenideProxyServer.start();
        Proxy seleniumProxy = selenideProxyServer.getSeleniumProxy();
        seleniumProxy.setNoProxy("github.com");
        return selenideProxyServer;
    }
}
