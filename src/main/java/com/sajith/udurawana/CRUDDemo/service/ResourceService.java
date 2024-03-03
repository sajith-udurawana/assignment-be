package com.sajith.udurawana.CRUDDemo.service;

import java.io.IOException;

/**
 * Service interface for fetching resources from URLs.
 * Defines a method for retrieving a resource from a given URL.
 * 
 * @param url The URL of the resource to fetch.
 * @return The fetched resource as a string.
 * @throws IOException If an I/O error occurs while fetching the resource.
 */
public interface ResourceService {
    String getResource(String url) throws IOException;
}
