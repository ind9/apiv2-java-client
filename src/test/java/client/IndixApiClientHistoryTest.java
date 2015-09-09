package client;


import client.impl.IndixApiClientFactory;
import exception.IndixApiException;
import httpClient.HttpClient;
import models.product.productAtStore.ProductHistoryAtStore;
import models.product.productAtStore.offer.ProductOfferHistory;
import org.junit.Test;
import query.ProductHistoryQuery;
import query.QueryFactory;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IndixApiClientHistoryTest {

    @Test
    public void getProductHistory() throws IOException, IndixApiException {

        MockResourceHttpClient mockHttpClientInstance = new MockResourceHttpClient();
        HttpClient mockHttpClient = mockHttpClientInstance.getMockClient("productHistory-json-responses0/productHistory.json");

        IndixApiClient indixApiClient = IndixApiClientFactory.newIndixApiClient("123", "123", mockHttpClient);

        try {
            ProductHistoryQuery productHistoryQuery = QueryFactory.newProductHistoryQuery()
                    .withCountryCode("US")
                    .withStoreId(271)
                    .withMpid("mpid1");
            ProductHistoryAtStore productHistoryRecord = indixApiClient.getProductHistory(productHistoryQuery).getProductHistory().getStores().get("271");
            ProductOfferHistory productOfferHistory = productHistoryRecord.getOffers().get(0);

            assertThat(productOfferHistory.getListPriceHistory(), hasItems(18.98, 19.98, 20.98));
            assertThat(productOfferHistory.getSalePriceHistory(), hasItems(18.00, 19.00, 20.00));
            assertThat(productOfferHistory.getPid(), is("pid1"));
            assertThat(productOfferHistory.getSeller(), is("seller"));
            assertThat(productOfferHistory.getTimestampHistory(), hasItems(1395644011000L, 1395415299000L, 1394371160000L));

            assertThat(productHistoryRecord.getStoreId(), is(111));
            assertThat(productHistoryRecord.getStoreName(), is("storename"));
            assertThat(indixApiClient.getProductHistory(productHistoryQuery).getProductHistory().getBrandId(), is(1547));
            assertThat(indixApiClient.getProductHistory(productHistoryQuery).getProductHistory().getCategoryId(), is(12345));


        } finally {
            indixApiClient.close();
        }
    }
}
