package com.example.organization.mapper.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponses();
    ModelMapper forRequest();
}
