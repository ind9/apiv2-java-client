package models.searchResponse.searchResult;

import models.product.OffersProduct;

import java.util.List;

public class OffersSearchResult extends SearchResult {
    private List<OffersProduct> products;

    public List<OffersProduct> getOffersProducts() {
        return products;
    }
}
