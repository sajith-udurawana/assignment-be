package com.sajith.udurawana.CRUDDemo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.sajith.udurawana.CRUDDemo.service.ResourceService;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    @Override
    public String getResource(String urlStr) {
        try {
            InputStream inputStream = new URL(urlStr).openStream();
            String out = IOUtils.toString(inputStream);
            inputStream.close();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
