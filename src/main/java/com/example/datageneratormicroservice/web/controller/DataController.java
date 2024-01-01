package com.example.datageneratormicroservice.web.controller;

import com.example.datageneratormicroservice.model.Data;
import com.example.datageneratormicroservice.model.test.DataTestOptions;
import com.example.datageneratormicroservice.service.KafkaDataService;
import com.example.datageneratormicroservice.service.TestDataService;
import com.example.datageneratormicroservice.web.dto.DataDTO;
import com.example.datageneratormicroservice.web.dto.DataTestOptionsDTO;
import com.example.datageneratormicroservice.web.mapper.DataMapper;
import com.example.datageneratormicroservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final DataMapper dataMapper;
    private final TestDataService testDataService;

    private final KafkaDataService kafkaDataService;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDTO dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDTO testOptionDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionDto);
        testDataService.sendMessages(testOptions);
    }

}
