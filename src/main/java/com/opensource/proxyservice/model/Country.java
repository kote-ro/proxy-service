package com.opensource.proxyservice.model;

import java.util.List;

public record Country(String fullName, String capital, List<String> continents, String currentTime) {
}
