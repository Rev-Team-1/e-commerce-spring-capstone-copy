package com.revature.stepimplementations.orderhistory;

import com.revature.stepimplementations.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistorySteps {

    // BACKGROUND
    @Given("User is on login page")
    public void user_is_on_login_page() {
        Hooks.driver.get("http://localhost:3000/login");
    }

    @When("User enters an email")
    public void user_enters_an_email() {
        Hooks.loginPage.emailInput.sendKeys("jane@gmail.com");
    }

    @When("User enters a password")
    public void user_enters_a_password() {
        Hooks.loginPage.passwordInput.sendKeys("password");
    }

    @When("User clicks login")
    public void user_clicks_login() {
        Hooks.loginPage.loginButton.click();
    }

    @Then("User logs in to Front page")
    public void user_logs_in_to_front_page() {
        Hooks.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        String actual = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:3000/", actual);
    }

    @When("User clicks the Orders link")
    public void user_clicks_the_orders_link() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']//strong[contains(text(), 'ORDERS')]")));
        Hooks.frontPage.ordersButton.click();
    }

    @Then("User navigates to the Orders page")
    public void user_navigates_to_the_orders_page() {
        Hooks.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/orders"));
        String actual = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:3000/orders", actual);
    }

    // VIEW LIST OF PREVIOUS ORDERS

    @Given("User is on the Orders page")
    public void user_is_on_the_orders_page() {
        String actual = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:3000/orders", actual);
    }

    @Then("User sees a list of their previous orders")
    public void user_sees_a_list_of_their_previous_orders() {

    }

    @Then("User can see the order date and total of each order")
    public void user_can_see_the_order_date_and_total_of_each_order() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//span[2]//p[1]")));
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//span[2]//p[2]")));
        String actualDate = Hooks.orderPage.orderDate.getText();
        String actualTotal = Hooks.orderPage.orderTotal.getText();
        Assert.assertEquals("Order date: 2022-12-16", actualDate);
        Assert.assertEquals("Order total: $10", actualTotal);
    }

    // VIEW ORDER DETAILS OF PREVIOUS ORDERS
    @Then("User can view the order detail ID and order ID")
    public void user_can_view_the_order_detail_id_and_order_id() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//div[2]/div/p[1]")));
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//div[2]/div/p[2]")));
        String actualOrderDetailId = Hooks.orderPage.capOrderDetailId.getText();
        String actualOrderId = Hooks.orderPage.capOrderId.getText();
        Assert.assertEquals("OrderDetail ID: 4", actualOrderDetailId);
        Assert.assertEquals("Order ID: 3", actualOrderId);
    }

    @Then("User can view the product purchased")
    public void user_can_view_the_product_purchased() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]//div[2]//a[@href='/products/4']")));
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//div[1]/div/p")));
        String actualProd = Hooks.orderPage.capLink.getText();
        String actualDesc = Hooks.orderPage.capDescription.getText();
        Assert.assertEquals("Baseball Cap", actualProd);
        Assert.assertEquals("A fancy cap for a fancy person", actualDesc);
    }

    @Then("User can view the product ID and quantity of the product purchased")
    public void user_can_view_the_product_id_and_quantity_of_the_product_purchased() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//div[2]/div/p[3]")));
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//div[4]/div[1]//div[2]/div/p[4]")));
        String actualProductId = Hooks.orderPage.capProductId.getText();
        String actualQuantity = Hooks.orderPage.capQuantity.getText();
        Assert.assertEquals("Product ID: 4", actualProductId);
        Assert.assertEquals("Quantity: 1", actualQuantity);
    }

    // VIEW PRODUCT DETAILS OF A PREVIOUS ORDER

    @When("User clicks on the name of a product from a previous order")
    public void user_clicks_on_the_name_of_a_product_from_a_previous_order() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']//div[4]//div[2]//a[@href='/products/4']")));
        Hooks.orderPage.capLink.click();
    }
    @Then("User navigates to the details page of the product")
    public void user_navigates_to_the_details_page_of_the_product() {
        Hooks.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/products/4"));
        String actual = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:3000/products/4", actual);
    }
    @Then("User can view product rating and reviews")
    public void user_can_view_product_rating_and_reviews() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']/div[2]/div[3]/span")));
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']/div[2]/div[3]/div[3]")));
    }

    // DELETE PRODUCT REVIEW FROM PREVIOUS ORDER

    @When("User clicks the delete button for their previous review")
    public void user_clicks_the_delete_button_for_their_previous_review() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']/div[2]/div[3]/div[3]//button")));
        Hooks.productDetailsPage.reviewDeleteButton.click();
    }
    @Then("The review is removed from the product reviews")
    public void the_review_is_removed_from_the_product_reviews() {
        Hooks.wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='root']/div[2]/div[3]/div[3]//p"), "No reviews.."));
        //String actual = productDetailsPage.productReviews.getText();
        String actual = Hooks.productDetailsPage.noReviewsMessage.getText();
        Assert.assertEquals("No reviews..", actual);
    }

    // ADD PRODUCT REVIEW TO PREVIOUS ORDER

    @When("User selects a rating for the product")
    public void user_selects_a_rating_for_the_product() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']/div[2]/div[3]/div[2]//label[5]")));
        Hooks.productDetailsPage.productFiveStarRating.click();
    }
    @When("User enters a review for the product")
    public void user_enters_a_review_for_the_product() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']/div[2]/div[3]/div[2]/div[1]//textarea")));
        Hooks.productDetailsPage.productReviewInput.sendKeys("This hat fits my head nicely.");
    }
    @When("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']/div[2]/div[3]/div[2]/div[2]//button")));
        Hooks.productDetailsPage.submitButton.click();
    }
    @Then("User sees their rating and review added to the product reviews")
    public void user_sees_their_rating_and_review_added_to_the_product_reviews() {
        Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']/div[2]/div[3]/div[3]/div")));
        String actual = Hooks.productDetailsPage.productReviews.getText();
        Assert.assertEquals("Jane" + "\n" + "This hat fits my head nicely.", actual);
    }
}

