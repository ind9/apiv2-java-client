package models.searchResponse.searchResult;

import models.product.CatalogStandardProduct;

import java.util.List;

public class CatalogStandardSearchResult extends SearchResult {
    private List<CatalogStandardProduct> products;

    public List<CatalogStandardProduct> getCatalogStandardProducts() {
        return products;
    }
}
