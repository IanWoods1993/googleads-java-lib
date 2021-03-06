// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dfp.axis.v201611.productservice;

import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.dfp.axis.factory.DfpServices;
import com.google.api.ads.dfp.axis.utils.v201611.StatementBuilder;
import com.google.api.ads.dfp.axis.v201611.Product;
import com.google.api.ads.dfp.axis.v201611.ProductPage;
import com.google.api.ads.dfp.axis.v201611.ProductServiceInterface;
import com.google.api.ads.dfp.axis.v201611.UpdateResult;
import com.google.api.ads.dfp.lib.client.DfpSession;
import com.google.api.client.auth.oauth2.Credential;

/**
 * This example publishes a programmatic product to Marketplace.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class PublishProgrammaticProductsToMarketplace {

  // Set the ID of the product to publish to Marketplace.
  private static final String PRODUCT_ID = "INSERT_PRODUCT_ID_HERE";

  public static void runExample(DfpServices dfpServices, DfpSession session,
      long productId) throws Exception {
    // Get the ProductService.
    ProductServiceInterface productService =
        dfpServices.get(session, ProductServiceInterface.class);

    // Create a statement to select a single product by ID.
    StatementBuilder statementBuilder = new StatementBuilder()
        .where("WHERE id = :id")
        .orderBy("id ASC")
        .limit(StatementBuilder.SUGGESTED_PAGE_LIMIT)
        .withBindVariableValue("id", productId);

    int totalResultSetSize = 0;

    do {
      ProductPage page = productService.getProductsByStatement(statementBuilder.toStatement());

      if (page.getResults() != null) {
        totalResultSetSize = page.getTotalResultSetSize();
        int i = page.getStartIndex();
        for (Product product : page.getResults()) {
          System.out.printf(
              "%d) Product with ID %d will be published.%n", i++,
              product.getId());
        }
      }

      statementBuilder.increaseOffsetBy(StatementBuilder.SUGGESTED_PAGE_LIMIT);
    } while (statementBuilder.getOffset() < totalResultSetSize);

    System.out.printf("Number of products to be published: %d%n", totalResultSetSize);

    if (totalResultSetSize > 0) {
      // Remove limit and offset from statement.
      statementBuilder.removeLimitAndOffset();

      // Create action.
      com.google.api.ads.dfp.axis.v201611.PublishProducts action =
          new com.google.api.ads.dfp.axis.v201611.PublishProducts();

      // Perform action.
      UpdateResult result = productService.performProductAction(
          action, statementBuilder.toStatement());

      if (result != null && result.getNumChanges() > 0) {
        System.out.printf("Number of products published: %d%n", result.getNumChanges());
      } else {
        System.out.println("No products were published.");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.DFP)
        .fromFile()
        .build()
        .generateCredential();

    // Construct a DfpSession.
    DfpSession session = new DfpSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    DfpServices dfpServices = new DfpServices();

    runExample(dfpServices, session, Long.parseLong(PRODUCT_ID));
  }
}
