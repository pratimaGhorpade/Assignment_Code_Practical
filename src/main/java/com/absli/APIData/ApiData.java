package com.absli.APIData;
import Utils.ExcelUtils;
import com.absli.base.TestBase;
import com.absli.utils.PropertiesUtils;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiData extends TestBase {

    public PropertiesUtils prop;

    public String parameterName;

    public ApiData()throws IOException {
        prop = new PropertiesUtils();
        prop.getProperties("testExcelSheet");
    }

  /*  public String getToken(String username, String password) throws IOException {
        prop.getProperties("env");
        // parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("isPasswordEncrypted", false);
        jsonBody.addProperty("isVerbose", false);
        jsonBody.addProperty("loginId", username);
        jsonBody.addProperty("screenCode", "login");
        jsonBody.addProperty("actionCode", "loginSubmit");
        jsonBody.addProperty("password", password);

        String baseUri;
        if(prop.getProperties("env").equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/stateMachines/startExecutionAws";
        } else if (prop.getProperties("env").equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/stateMachines/startExecutionAws";
        }
        else if (prop.getProperties("env").equalsIgnoreCase("Preprod")) {
            baseUri = "https://leappreprod.adityabirlasunlifeinsurance.com/api/stateMachines/startExecutionAws";
        }
        else {
            return "Incorrect Environment value";
        }

        RequestSpecification request = RestAssured.given().baseUri(baseUri).headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.getString("token");
        return token;

    }*/

    public String getToken(String username, String password) throws IOException {

        parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("isPasswordEncrypted", false);
        jsonBody.addProperty("isSkipAdAuth", true);
        jsonBody.addProperty("loginId", username);
        jsonBody.addProperty("password", password);

        String baseUri;
        if(parameterName.equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/users/login";
        } else if (parameterName.equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/users/login";
        }else if (parameterName.equalsIgnoreCase("Preprod")) {
            baseUri = "https://leappreprod.adityabirlasunlifeinsurance.com/leap-preprod-server/api/customers/rnaLink";
        } 
        else {
            // Return an error or throw an exception if the parameterName is not recognized
            return "Incorrect Environment value";
        }

        RequestSpecification request = RestAssured.given().baseUri(baseUri).headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("token");
        return token;

    }


  /*  public String getTokenUAT(String username, String password) {
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("isPasswordEncrypted", false);
        jsonBody.addProperty("isSkipAdAuth", true);
        jsonBody.addProperty("loginId", username);
        jsonBody.addProperty("password", password);
        RequestSpecification request = RestAssured.given()
                .baseUri("https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/users/login")
                .headers(headersMap).body(jsonBody.toString());
        System.out.println(jsonBody.toString());
        Response response = request.post();
        // System.out.println(response.getStatusCode() + " " +
        // response.getBody().toString());
        // System.out.println(response.asPrettyString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("token");
        System.out.println("Token :" + token);
        return token;
    }*/

    public String getApplicationId(String username, String appnumber, String token) throws IOException  {
        parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("loginId", username);
        jsonBody.addProperty("applicationNumber", appnumber);

        String baseUri;
        if(parameterName.equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/customers/getApplication";
        } else if (parameterName.equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/getApplication";
        } else if (parameterName.equalsIgnoreCase("Preprod")) {
            baseUri = "https://leappreprod.adityabirlasunlifeinsurance.com/leap-preprod-server/api/customers/rnaLink";
        }
        else {
            // Return an error or throw an exception if the parameterName is not recognized
            return "Incorrect Environment value";
        }

        RequestSpecification request = RestAssured.given().baseUri(baseUri).headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String applicationId = jsonPathEvaluator.get("data.applicationId");
        System.out.println("applicationId :" + applicationId);
        return applicationId;
    }

  /*  public String getApplicationIdUAT(String username, String appnumber, String token) {
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("loginId", username);
        jsonBody.addProperty("applicationNumber", appnumber);
        RequestSpecification request = RestAssured.given()
                .baseUri("https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/getApplication")
                .headers(headersMap).body(jsonBody.toString());
        System.out.println(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        // System.out.println(response.asPrettyString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String applicationId = jsonPathEvaluator.get("data.applicationId");
        System.out.println("applicationId :" + applicationId);
        return applicationId;
    }*/

    public String getRNALink(String username, String appnumber, String applicationid, String token)  throws IOException {
        parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", applicationid);
        jsonBody.addProperty("type", "link");

        String baseUri;
        if(parameterName.equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/customers/rnaLink";
        } else if (parameterName.equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/rnaLink";
        }else if (parameterName.equalsIgnoreCase("Preprod")) {
            baseUri = "https://leappreprod.adityabirlasunlifeinsurance.com/leap-preprod-server/api/customers/rnaLink";
        }
        
        else {
            // Return an error or throw an exception if the parameterName is not recognized
            return "Error: Unrecognized parameterName value";
        }

        RequestSpecification request = RestAssured.given().baseUri(baseUri).queryParam("loginId", username).queryParam("applicationNumber", appnumber).headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String url = jsonPathEvaluator.get("data.tinyURLResult");
        System.out.println("URL :" + url);
        return url;

    }

/*
    public String getRNALinkUAT(String username, String appnumber, String applicationid, String token) {
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", applicationid);
        jsonBody.addProperty("type", "link");
        RequestSpecification request = RestAssured.given()
                .baseUri("https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/rnaLink")
                .queryParam("loginId", username).queryParam("applicationNumber", appnumber).headers(headersMap)
                .body(jsonBody.toString());
        System.out.println(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String url = jsonPathEvaluator.get("data.tinyURLResult");
        System.out.println("URL :" + url);
        return url;
    }*/

    public Integer getOTP(String username, String appnumber, String applicationid, String token)  throws IOException {
        parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", applicationid);

        String baseUri = null;
        if(parameterName.equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/customers/rnaLink";
        } else if (parameterName.equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/rnaLink";

        }
        RequestSpecification request = RestAssured.given().baseUri(baseUri).queryParam("loginId", username).queryParam("applicationNumber", appnumber).headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        int OTP = jsonPathEvaluator.get("data.verificationCode");
        System.out.println("OTP :" + OTP);
        return OTP;

    }

/*
    public Integer getOTPUAT(String username, String appnumber, String applicationid, String token) {
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", applicationid);
        RequestSpecification request = RestAssured.given()
                .baseUri("https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/customers/rnaLink")
                .queryParam("loginId", username).queryParam("applicationNumber", appnumber).headers(headersMap)
                .body(jsonBody.toString());
        System.out.println(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        int OTP = jsonPathEvaluator.get("data.verificationCode");
        System.out.println("OTP :" + OTP);
        return OTP;
    }*/

/*
    public String getPDF(String loginID, String applicationNum, String token) {
        //    String Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dpbklkIjoiUEtEdEVXTXZHZmplSUQ4VGRJUmtxbFlTYXJMSW9BSW9kdSt1RitmRHRPbzhwZXIyWFRzNUpQa0Q4RnlIK0FFbmpDK0NPdGpYQ3I3UCt4b1REcFBBVEE9PSIsImNoYW5uZWxDb2RlIjoiYWczK0F0TUIzSVR1eUpiVC9hTEdsUlpwWCtIVnJKWW1WY1hUK0g5Y0kzV1IxQ3RJOVNGWEZQS1RXQStPUjZIK3FVNWl4TEI1WDF3V1Zic3ptVXJ2d0E9PSIsImNoYW5uZWxOYW1lIjoiY0FMUzkzN2NLd2djSzNtLytsMFl1cElnYjY2NG9PNkxTZlE2bWpIMnpnUGRHMDI5cmh2c1ZlSm5SditLTWNyTmJWaGptd2lma3RlcVlDZWdjQnNzTEE9PSIsImlhdCI6MTY3MDIzMTg3OSwiZXhwIjoxNjcwMzE4Mjc5LCJpc3MiOiJ1YXQifQ.bkoOnvdAPbmIQ6WF2sGCnmFYf3O5CcCLydLOxL_qyBg";
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", getApplicationId(loginID, applicationNum, token));
        RequestSpecification request = given()
                .baseUri("https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/stateMachines/startExecution")
                .queryParam("loginId", loginID).queryParam("applicationNumber", applicationNum).queryParam("screenCode", "pxMain")
                .queryParam("actionCode", "pxIllustrationPdf")
                .headers(headersMap)
                .body(jsonBody.toString());
        System.out.println(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String fileName = jsonPathEvaluator.get("data.fileName");
        String pdfByte = jsonPathEvaluator.get("data.pdfBytes");
        System.out.println(pdfByte);
        String concat = fileName + " " + pdfByte;

        return concat;
    }  
    */
    
    
    
    public String getPDF(String loginID, String applicationNum, String token) throws IOException {
        parameterName = ExcelUtils.getURLEnvironment(prop.getProperties("testExcelSheet"), "controller");
        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Authorization", "Bearer " + token);
        JsonObject jsonBody = new JsonObject();
        System.out.println("Token : " + token);
        jsonBody.addProperty("applicationId", getApplicationId(loginID, applicationNum, token));

        String baseUri;
        if(parameterName.equalsIgnoreCase("QA")) {
            baseUri = "https://leapdev.adityabirlasunlifeinsurance.com/leap-qa-server/api/stateMachines/startExecution";
        } else if (parameterName.equalsIgnoreCase("UAT")) {
            baseUri = "https://leapuat.adityabirlasunlifeinsurance.com/leap-uat-server/api/stateMachines/startExecution";
        } else {
            // Return an error or throw an exception if the parameterName is not recognized
            return "Error: Unrecognized parameterName value";
        }

        RequestSpecification request = RestAssured.given().baseUri(baseUri).queryParam("loginId", loginID).queryParam("applicationNumber", applicationNum).queryParam("screenCode", "pxMain").queryParam("actionCode", "pxIllustrationPdf").headers(headersMap).body(jsonBody.toString());
        Response response = request.post();
        System.out.println(response.getStatusCode() + " " + response.getBody().toString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String fileName = jsonPathEvaluator.get("data.fileName");
        String pdfByte = jsonPathEvaluator.get("data.pdfBytes");
        System.out.println(pdfByte);
        String concat = fileName + " " + pdfByte;

        return concat;

    }
}