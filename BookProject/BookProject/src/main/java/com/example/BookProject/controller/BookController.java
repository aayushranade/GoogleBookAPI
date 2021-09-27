package com.example.BookProject.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.example.BookProject.model.BookModel;
import com.example.BookProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.*;

@RestController
@Slf4j
public class BookController {

    private String gURL = "https://www.googleapis.com/books/v1/volumes";

    @Autowired
    BookModel BookModelObj;

    @Autowired
    BookRepository BookRepositoryobj;

    @RequestMapping("/get")
    public void getBook(@RequestParam String q) throws IOException, JSONException {

        gURL=gURL + "?" + URLEncoder.encode("q") + "=" + URLEncoder.encode(q) + URLEncoder.encode("maxResults") + "=" + URLEncoder.encode("14");
        URL url = new URL(gURL);
        //URL url = new URL("https://www.googleapis.com/books/v1/volumes?q={search terms}");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader bufr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = bufr.readLine()) != null) {
            response.append(inputLine);
        } bufr.close();
        JSONObject result = new JSONObject(response.toString());
        //JSONArray array = (JSONArray) result.get("data");
        //System.out.println(result);
        JSONArray arr = (JSONArray) result.get("items");
        for(int i=0;i<arr.length();i++){
            JSONObject obj= arr.getJSONObject(i);
//            System.out.println(obj);
//            System.out.println("\n" + "Kind: "+ obj.get("kind"));
//            System.out.println("\n" + "ID: "+ obj.get("id"));
//            System.out.println("\n" + "Etag: "+ obj.get("etag"));
//            System.out.println("\n" + "Google Link: "+ obj.get("selfLink"));
            String kind = obj.get("kind").toString();
            String id = obj.get("id").toString();
            String etag = obj.get("etag").toString();
            String link = obj.get("selfLink").toString();
            //System.out.println(kind);
            BookRepositoryobj.insertNewBookToDatabase(kind,id,etag,link);
        }
    }

//obj.get("id")
    //obj.get("volume


//for (let key in myJSONObject.abc) {
//        let value = myJSONObject.abc[key];
//        for (let i = 0; i <= value.length; i++) {
//            console.log(value[[i]]);
//        }


//    JSONArray arr = (JSONArray) result.get("items");
//        for(int i=0;i<arr.length();i++){
//            JSONObject obj= arr.getJSONObject(i);
//            System.out.println(obj);
//            System.out.println("\n" + "Kind: "+ obj.get("kind"));
//            System.out.println("\n" + "ID: "+ obj.get("id"));
//            System.out.println("\n" + "Etag: "+ obj.get("etag"));
//            System.out.println("\n" + "Google Link: "+ obj.get("selfLink"));
//        }

//    JSONArray varr = (JSONArray) result.get("volumeInfo");
//        for(int j=0;j<varr.length();j++){
//        JSONObject vobj= varr.getJSONObject(j);
//        System.out.println(vobj);
//
//    }
















//    @PostMapping("/signup")
//    public String signup(WebRequest webRequest){
//        String username = webRequest.getParameter("username");
//        String email = webRequest.getParameter("email");
//        String password = webRequest.getParameter("password");
//        String vpassword = webRequest.getParameter("vpassword");
//        if(password == vpassword){
//            BookRepositoryobj.insertNewUser(username,email,password);
//        }
//        else{
//            System.out.println("enter correct passwords");
//        }
//        return "Signup Success!!";
//    }
//    @PostMapping("/login")
//    public String login(WebRequest webRequest){
//        String username = webRequest.getParameter("username");
//        String password = webRequest.getParameter("password");
//        repositoryobj.getDetails(password);
//        System.out.println("Hi" + username);
//        return "login success";
//    }
}
