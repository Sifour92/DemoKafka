package com.example.datageneratormicroservice.web.mapper;

import com.example.datageneratormicroservice.model.Data;
import com.example.datageneratormicroservice.web.dto.DataDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDTO> {
}
