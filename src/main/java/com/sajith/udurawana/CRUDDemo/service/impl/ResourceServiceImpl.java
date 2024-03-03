package com.sajith.udurawana.CRUDDemo.service.impl;

import com.sajith.udurawana.CRUDDemo.service.ResourceService;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    @Override
    public String getResource(String urlStr) throws IOException {
        InputStream inputStream = new URL(urlStr).openStream();
        String out = IOUtils.toString(inputStream);
        inputStream.close();
        return out;
    }

}
