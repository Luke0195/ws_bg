package br.com.gobarber.utils.http;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class HttpHelper {

    private HttpHelper(){};

    public static  URI addUriRequest(Object object){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object).toUri();
    }
}
