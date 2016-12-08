package com.indix.client.impl;

import com.indix.client.IndixApiClient;
import com.indix.httpClient.HttpClient;

/**
 * Instantiates IndixApiClient instances
 */
public class IndixApiClientFactory {

    /**
     * @param appKey application key
     * @return {@link IndixApiClient}
     */
    public static IndixApiClient newIndixApiClient(String appKey) {
        return new IndixApiClientImpl(appKey);
    }

    /**
     * Used for mocking http client for testing purpose.
     * @param appKey application key
     * @param httpClient mock http client
     * @return {@link IndixApiClient}
     */
    public static IndixApiClient newIndixApiClient(String appKey, HttpClient httpClient) {
        return new IndixApiClientImpl(appKey, httpClient);
    }


    /**
     * Used for setting server scheme and host for testing purpose.
     * @param appKey application key
     * @param scheme http scheme
     * @param host api host to be queried
     * @return {@link IndixApiClient}
     */
    public static IndixApiClient newIndixApiClient(String appKey, String scheme, String host) {
        return new IndixApiClientImpl(appKey, scheme, host);
    }
}
