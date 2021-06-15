package com.communication.outboundcallreminder.EventHandler;

import com.communication.outboundcallreminder.ConfigurationManager;

public class EventAuthHandler {
    private String SecretKey = "secret";
    private String SecretValue;
    public static EventAuthHandler eventAuthHandler = null;

    public EventAuthHandler() {
        ConfigurationManager configuration = ConfigurationManager.GetInstance();
        SecretValue = configuration.GetAppSettings("SecretPlaceholder");

        if (SecretValue == null) {
            System.out.println("SecretPlaceholder is null");
            SecretValue = "h3llowW0rld";
        }
    }

    public static EventAuthHandler GetInstance() {
        if (eventAuthHandler == null) {
            eventAuthHandler = new EventAuthHandler();
        }
        return eventAuthHandler;
    }

    public Boolean Authorize(String requestSecretValue) {
        if (requestSecretValue != null && requestSecretValue.equals(SecretValue)) {
            return true;
        }
        return false;
    }

    public String GetSecretQuerystring() {
        return (this.SecretKey + "=" + SecretValue);
    }
}