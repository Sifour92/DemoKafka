package com.example.datageneratormicroservice.web.dto;

import com.example.datageneratormicroservice.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDTO {
    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}
