package com.example.UserGroup.mapper.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponses();
    ModelMapper forRequest();
}
