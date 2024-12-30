package com.example.Roles.mapper.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponses();
    ModelMapper forRequest();
}
