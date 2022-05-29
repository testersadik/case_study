package com.case_study.api_testing;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import  static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class api_test {
    @Test
    public void test1() {
        Response response = RestAssured.get(" https://automationexercise.com/api/productsList");
        // print the status code
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }
     @Test
     public void test2(){
         Response response = RestAssured.post("https://automationexercise.com/api/verifyLogin");

         // print the status code
         System.out.println(response.statusCode());
         System.out.println(response.body().asString()); }
                                              
     @Test
     public void test3(){
         Response response = RestAssured.given().queryParam("email","sadikozturk0610@gmail.com")
                 .and().queryParam("password","123456")
                 .when().post("https://automationexercise.com/api/verifyLogin");

         // print the status code
         System.out.println(response.statusCode());
         System.out.println(response.body().asString()); }

     @Test
     public void test4(){
          given().queryParam("search_product","jean")
                 .when().post("https://automationexercise.com/api/searchProduct")
                 .then().assertThat().statusCode(200);

         // print the status code
         //System.out.println("response.statusCode() = " + response.statusCode());
         //System.out.println(response.body().asString()); }

}
} 