package com.website.config;

import org.testng.SkipException;

public class StatusCodeWebSite {

  public boolean testStatusUrl(int statusCode) {
    switch (statusCode) {
      case 100:
        System.out.println("error Continue " + statusCode);
        throw new SkipException("Skipping this exception");
      case 101:
        System.out.println("Switching Protocols " + statusCode);
        throw new SkipException("Skipping this exception");
      case 102:
        System.out.println("Processing " + statusCode);
        throw new SkipException("Skipping this exception");
      case 200:
        System.out.println("Page Connection Success OK " + statusCode);
        return true;
      case 201:
        System.out.println("Created " + statusCode);
        throw new SkipException("Skipping this exception");
      case 202:
        System.out.println("Accepted " + statusCode);
        throw new SkipException("Skipping this exception");
      case 203:
        System.out.println("Non-Authoritative Information " + statusCode);
        throw new SkipException("Skipping this exception");
      case 204:
        System.out.println("No Content " + statusCode);
        throw new SkipException("Skipping this exception");
      case 205:
        System.out.println("Reset Content " + statusCode);
        throw new SkipException("Skipping this exception");
      case 206:
        System.out.println("Partial Content " + statusCode);
        throw new SkipException("Skipping this exception");
      case 300:
        System.out.println("Multiple Choices " + statusCode);
        throw new SkipException("Skipping this exception");
      case 301:
        System.out.println("Moved Permanently " + statusCode);
        throw new SkipException("Skipping this exception");
      case 302:
        System.out.println("Found " + statusCode);
        throw new SkipException("Skipping this exception");
      case 303:
        System.out.println("See Other " + statusCode);
        throw new SkipException("Skipping this exception");
      case 304:
        System.out.println("Not Modified " + statusCode);
        throw new SkipException("Skipping this exception");
      case 305:
        System.out.println("Use Proxy " + statusCode);
        throw new SkipException("Skipping this exception");
      case 306:
        System.out.println("Unused " + statusCode);
        throw new SkipException("Skipping this exception");
      case 307:
        System.out.println("Temporary Redirect " + statusCode);
        throw new SkipException("Skipping this exception");
      case 308:
        System.out.println("Permanent Redirect " + statusCode);
        throw new SkipException("Skipping this exception");
      case 400:
        System.out.println("Bad Request " + statusCode);
        throw new SkipException("Skipping this exception");
      case 401:
        System.out.println("Unauthorized " + statusCode);
        throw new SkipException("Skipping this exception");
      case 402:
        System.out.println("Payment Required " + statusCode);
        throw new SkipException("Skipping this exception");
      case 403:
        System.out.println("Forbidden " + statusCode);
        throw new SkipException("Skipping this exception");
      case 404:
        System.out.println("Not Found " + statusCode);
        throw new SkipException("Skipping this exception");
      case 405:
        System.out.println("Method Not Allowed " + statusCode);
        throw new SkipException("Skipping this exception");
      case 406:
        System.out.println("Not Acceptable " + statusCode);
        throw new SkipException("Skipping this exception");
      case 407:
        System.out.println("Proxy Authentication Required " + statusCode);
        throw new SkipException("Skipping this exception");
      case 408:
        System.out.println("Request Timeout " + statusCode);
        throw new SkipException("Skipping this exception");
      case 409:
        System.out.println("Conflict " + statusCode);
        throw new SkipException("Skipping this exception");
      case 410:
        System.out.println("Gone " + statusCode);
        throw new SkipException("Skipping this exception");
      case 411:
        System.out.println("Length Required " + statusCode);
        throw new SkipException("Skipping this exception");
      case 412:
        System.out.println("Precondition Failed " + statusCode);
        throw new SkipException("Skipping this exception");
      case 413:
        System.out.println("Request Entity Too Large " + statusCode);
        throw new SkipException("Skipping this exception");
      case 414:
        System.out.println("Request-URI Too Long " + statusCode);
        throw new SkipException("Skipping this exception");
      case 415:
        System.out.println("Unsupported Media Type " + statusCode);
        throw new SkipException("Skipping this exception");
      case 416:
        System.out.println("Requested Range Not Satisfiable " + statusCode);
        throw new SkipException("Skipping this exception");
      case 417:
        System.out.println("Expectation Failed " + statusCode);
        throw new SkipException("Skipping this exception");
      case 422:
        System.out.println("Unprocessable Entity " + statusCode);
        throw new SkipException("Skipping this exception");
      case 428:
        System.out.println("Precondition Required " + statusCode);
        throw new SkipException("Skipping this exception");
      case 429:
        System.out.println("Too Many Requests " + statusCode);
        throw new SkipException("Skipping this exception");
      case 431:
        System.out.println("Request Header Fields Too Large " + statusCode);
        throw new SkipException("Skipping this exception");
      case 451:
        System.out.println("Unavailable For Legal Reasons " + statusCode);
        throw new SkipException("Skipping this exception");
      case 500:
        System.out.println("Internal Server Error " + statusCode);
        throw new SkipException("Skipping this exception");
      case 501:
        System.out.println("Not Implemented " + statusCode);
        throw new SkipException("Skipping this exception");
      case 502:
        System.out.println("Bad Gateway " + statusCode);
        throw new SkipException("Skipping this exception");
      case 503:
        System.out.println("Service Unavailable " + statusCode);
        throw new SkipException("Skipping this exception");
      case 504:
        System.out.println("Gateway Timeout " + statusCode);
        throw new SkipException("Skipping this exception");
      case 505:
        System.out.println("HTTP Version Not Supported " + statusCode);
        throw new SkipException("Skipping this exception");
      case 511:
        System.out.println("Network Authentication Required " + statusCode);
        throw new SkipException("Skipping this exception");
      case 520:
        System.out.println("Web server is returning an unknown error " + statusCode);
        throw new SkipException("Skipping this exception");
      case 522:
        System.out.println("Connection timed out " + statusCode);
        throw new SkipException("Skipping this exception");
      case 524:
        System.out.println("A timeout occurred " + statusCode);
        throw new SkipException("Skipping this exception");
      default:
        System.out.println("other problem of environment " + statusCode);
        return false;
    }
  }
}
