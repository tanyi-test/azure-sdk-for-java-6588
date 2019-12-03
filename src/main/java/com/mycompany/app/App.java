package com.mycompany.app;

import java.io.File;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
        ApplicationTokenCredentials credentials = ApplicationTokenCredentials.fromFile(credFile);
        Azure azure = Azure.configure()
                .authenticate(credentials)
                .withDefaultSubscription();

        for (int i = 0; i < 200; ++i) {
            azure.storageAccounts().list();
        }

        System.out.println(azure.storageAccounts().list().size()); // 23
    }
}
