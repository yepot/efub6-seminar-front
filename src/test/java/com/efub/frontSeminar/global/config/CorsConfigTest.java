package com.efub.frontSeminar.global.config;

import com.efub.frontSeminar.home.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CorsConfigTest {

    @Test
    void preflightRequestFromWildcardOriginPatternReturnsCorsHeaders() throws Exception {
        CorsConfig corsConfig = new CorsConfig(new String[]{"*"});
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
                .addFilters(corsConfig.corsFilter())
                .build();

        mockMvc.perform(options("/")
                        .header("Origin", "https://intern-preview.example.com")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "https://intern-preview.example.com"))
                .andExpect(header().string("Access-Control-Allow-Credentials", "true"));
    }
}
