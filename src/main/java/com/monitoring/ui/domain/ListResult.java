package com.monitoring.ui.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

@Data
public class ListResult {
    List<String> lsresult;
    JSONObject result ;
}
